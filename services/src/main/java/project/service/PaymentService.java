package project.service;

import project.exception.CardNotFoundException;
import project.exception.MoneyOperationException;
import project.service.model.Balance;
import project.service.model.WithdrawalResult;

import java.math.BigDecimal;

public interface PaymentService {

    /**
     * Return balance for specified card
     *
     * @param cardNumber
     * @return
     */
    Balance getBalance(String cardNumber) throws CardNotFoundException;

    /**
     * Withdraw specified amount from specified card
     *
     * @param cardNumber
     * @param amount
     * @return new balance
     * @throws CardNotFoundException if specified card is not found
     * @throws MoneyOperationException if not enough resources for operation
     */
    WithdrawalResult getCash(String cardNumber, BigDecimal amount) throws CardNotFoundException, MoneyOperationException;
}
