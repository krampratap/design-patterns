package behavioural.strategy;

import behavioural.strategy.payment.PaymentByPayPal;
import behavioural.strategy.payment.PaymentService;

//CLIENT
public class StrategyMain {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();
        //The strategy can be easily picked at runtime
        paymentService.setCost(10000);
        paymentService.setStrategy(new PaymentByPayPal());
        paymentService.processOrder();
    }
}
