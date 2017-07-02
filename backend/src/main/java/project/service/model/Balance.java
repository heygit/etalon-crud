package project.service.model;

import java.math.BigDecimal;

public class Balance {

    private String cardNumber;
    private long date;
    private BigDecimal amount;

    public Balance(String cardNumber, long date, BigDecimal amount) {
        this.cardNumber = cardNumber;
        this.date = date;
        this.amount = amount;
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
}
