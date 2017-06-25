package project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.dao.CardDao;
import project.dao.OperationDao;
import project.entity.Card;
import project.entity.Operation;
import project.exception.CardNotFoundException;
import project.exception.MoneyOperationException;
import project.service.PaymentService;
import project.utils.OperationType;

import java.math.BigDecimal;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final CardDao cardDao;
    private final OperationDao operationDao;

    @Autowired
    public PaymentServiceImpl(CardDao cardDao, OperationDao operationDao) {
        this.cardDao = cardDao;
        this.operationDao = operationDao;
    }

    @Override
    @Transactional
    public BigDecimal getBalance(String cardNumber) throws CardNotFoundException {
        Card card = cardDao.findOne(cardNumber);
        final long timeStamp = System.currentTimeMillis();
        checkIfNull(card, cardNumber);

        Operation operation = new Operation();
        operation.setCard(card);
        operation.setTimeStamp(timeStamp);
        operation.setOperationType(OperationType.SHOW_BALANCE);
        operationDao.save(operation);

        return card.getBalance();
    }

    //TODO: RETURN TIME TOO!!!

    @Override
    @Transactional
    public BigDecimal getCash(String cardNumber, BigDecimal amount) throws CardNotFoundException,
            MoneyOperationException {
        if (amount == null) {
            throw new IllegalArgumentException();
        }
        Card card = cardDao.findOneForUpdate(cardNumber);
        final long timeStamp = System.currentTimeMillis();
        final BigDecimal balance = card.getBalance();
        checkIfNull(card, cardNumber);
        if (amount.compareTo(balance) > 0) {
            throw new MoneyOperationException();
        }
        balance.subtract(amount);

        Operation operation = new Operation();
        operation.setCard(card);
        operation.setTimeStamp(timeStamp);
        operation.setOperationType(OperationType.GET_CASH);
        operation.setAmount(amount);
        operationDao.save(operation);
        return balance;
    }

    private void checkIfNull(Card card, String cardNumber) {
        if (card == null) {//TODO: CHECK IF IT RETURNS NULL!!!
            throw new CardNotFoundException("Could not find card " + cardNumber);
        }
    }

}
