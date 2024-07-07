package d_Behavioural.strategy.payment;


public class PaymentByCreditCard implements PaymentStrategy {
    private CreditCard card;
    @Override
    public void collectPaymentDetails() {
        //Pop-up to collect card details..
        card = new CreditCard("card Number","expiry date","cvv");
    }

    @Override
    public boolean validatePaymentDetails() {
        //Validate credit card
        return true;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paying "+amount+ " using Credit card");
        card.setAmount(card.getAmount()-amount);
    }
}
