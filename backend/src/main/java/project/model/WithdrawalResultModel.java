package project.model;

public class WithdrawalResultModel {

    private String cardNumber;
    private String date;
    private Currency amount;
    private Currency balance;

    public WithdrawalResultModel(String cardNumber, String date, Currency amount, Currency balance) {
        this.cardNumber = cardNumber;
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    public WithdrawalResultModel() {
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

    public Currency getBalance() {
        return balance;
    }

    public void setBalance(Currency balance) {
        this.balance = balance;
    }
}
