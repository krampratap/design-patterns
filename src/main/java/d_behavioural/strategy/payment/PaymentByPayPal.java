package d_behavioural.strategy.payment;

public class PaymentByPayPal implements PaymentStrategy {
    private String email;
    private String password;
    @Override
    public void collectPaymentDetails() {
        email = "abc@gmail.com";
        password = "hdhf";
    }

    @Override
    public boolean validatePaymentDetails() {
        return true;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paying " +amount + " using Paypal account");
    }
}
