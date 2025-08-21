package com.marakicode.springstore.ioc;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


//@Service
public class OrderService {
    private PaymentService paymentService;

//    @Autowired
    public OrderService(
//            @Qualifier("paypal")
            PaymentService paymentService) {
        this.paymentService = paymentService;
        System.out.println("OrderService created");
    }

    @PostConstruct
    public void init() {
        System.out.println("OrderService PostConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("OrderService PreDestroy");
    }

    public void placeOrder(Order order) {
        this.paymentService.placeOrder(order);
    }
}
