package com.marakicode.springstore.ioc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

//@Primary
//@Service("stripe")
public class StripPaymentService implements PaymentService {
    @Value("${stripe.apiUrl}")
    private String apiUrl;

    @Value("${stripe.enabled}")
    private boolean enabled;

    @Value("${stripe.timeout:2000}")
    private int timeout;

    @Value("${stripe.currencies}")
    private List<String> currencies;

    @Override
    public void placeOrder(Order order) {

        System.out.println(apiUrl);
        System.out.println(enabled);
        System.out.println(timeout);
        System.out.println(currencies);

        System.out.println("STRIPE");
        System.out.println("Order placed");
    }
}
