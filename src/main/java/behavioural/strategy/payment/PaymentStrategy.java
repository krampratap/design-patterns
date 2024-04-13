package behavioural.strategy.payment;

public interface PaymentStrategy {
    void collectPaymentDetails();
    boolean  validatePaymenrDetails();
    void pay(int amount);
}
