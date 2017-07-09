package project.model;

public class BalanceModel {

    private String cardNumber;
    private String date;
    private Currency amount;

    public BalanceModel(String cardNumber, String date, Currency amount) {
        this.cardNumber = cardNumber;
        this.date = date;
        this.amount = amount;
    }

    public BalanceModel() {
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Currency getAmount() {
        return amount;
    }

    public void setAmount(Currency amount) {
        this.amount = amount;
    }
}
