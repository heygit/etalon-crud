package project.service.model;

import java.math.BigDecimal;

public class WithdrawalResult {

    private String cardNumber;
    private long date;
    private BigDecimal amount;
    private BigDecimal balance;

    public WithdrawalResult(String cardNumber, long date, BigDecimal amount, BigDecimal balance) {
        this.cardNumber = cardNumber;
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
