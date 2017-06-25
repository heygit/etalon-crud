package project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.dao.CardDao;
import project.entity.Card;
import project.service.AuthService;
import project.service.CardStatus;

@Service
public class AuthServiceImpl implements AuthService {

    private final CardDao cardDao;

    @Autowired
    public AuthServiceImpl(CardDao cardDao) {
        this.cardDao = cardDao;
    }

    @Override
    public CardStatus checkCard(String cardNumber) {
        checkIfNull(cardNumber);
        Card card = cardDao.findOne(cardNumber);
        if (card == null) {
            return CardStatus.NOT_FOUND;
        } else if (card.isLocked()) {
            return CardStatus.LOCKED;
        } else {
            return CardStatus.OK;
        }
    }

    @Override
    public boolean checkPin(String cardNumber, String pin) {
        checkIfNull(cardNumber);
        checkIfNull(pin);
        //TODO!!!!!!!!!!!!!!!!!!!!!!!!!!
        return false;
    }

    private void checkIfNull(Object object) {
        if (object == null) {
            throw new IllegalArgumentException();
        }
    }
}
