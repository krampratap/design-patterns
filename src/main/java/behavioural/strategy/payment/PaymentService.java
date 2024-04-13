package behavioural.strategy.payment;

public class PaymentService {
    private int cost;
    private boolean includeDelivery;
    private PaymentStrategy strategy;

    public void processOrder(){
        strategy.collectPaymentDetails();
        if(strategy.validatePaymenrDetails())
        {
            strategy.pay(getTotal());
        }
    }

    private int getTotal() {
        return includeDelivery ? cost + 10 : cost;
    }

    /*
    This class has no visibility on how the payment is being made
    as it is making use of strategy interface.
     */

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setIncludeDelivery(boolean includeDelivery) {
        this.includeDelivery = includeDelivery;
    }

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }
}
