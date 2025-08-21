package com.marakicode.springstore.config;

import com.marakicode.springstore.ioc.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class AppConfig {
    @Value("${payment-gateway:paypal}")
    private String paymentGateway;

    @Value("${messaging-service:email}")
    private String messagingService;

    @Bean
    public NotificationService email() {
        return new EmailService();
    }

    @Bean
    public NotificationService sms() {
        return new SMSService();
    }

    @Bean
    public NotificationManager notificationManager() {
        if (messagingService.equalsIgnoreCase("email"))
            return new NotificationManager(email());
        return new NotificationManager(sms());
    }

    @Bean
    public PaymentService stripe(){
        return new StripPaymentService();
    }

    @Bean
    public PaymentService paypal(){
        return new PaypalPaymentService();
    }

    @Bean
//    @Scope("singleton") // Single instance of beans with eager loading , it is the default behavior
//    @Scope("application")  // same as above with lazy loading
//    @Scope("prototype") // have its own instance
//    @Scope("request") // when http request happen
//    @Scope("session") // when session handling happen

    public OrderService orderService(){
        if (paymentGateway.equalsIgnoreCase("paypal"))
            return new OrderService(paypal());
        return new OrderService(stripe());
    }

    @Lazy
    @Bean
    public HeavyResource heavyResource(){
        return new HeavyResource();
    }
}
