package behavioural.strategy.payment;

public class CreditCard {
    private int amount = 10000;
    private  String number;
    private  String date;
    private  String cvv;

    public CreditCard(String cardNumber, String expiryDate, String cvv) {
        this.number = cardNumber;
        this.date = expiryDate;
        this.cvv = cvv;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
