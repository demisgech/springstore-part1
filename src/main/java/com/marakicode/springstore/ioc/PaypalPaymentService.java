package com.marakicode.springstore.ioc;


import org.springframework.stereotype.Service;

//@Service("paypal")
public class PaypalPaymentService implements PaymentService {
    @Override
    public void placeOrder(Order order) {
        System.out.println("PAYPAL");
        System.out.println("Order placed");
    }
}
