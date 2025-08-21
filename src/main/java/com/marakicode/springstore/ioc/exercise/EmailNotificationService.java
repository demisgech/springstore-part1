package com.marakicode.springstore.ioc.exercise;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService implements NotificationService {
    @Value("${mail.host}")
    private String host;

    @Value("${mail.port}")
    private int port;

    @Override
    public void send(String message, String recipientEmail) {
        System.out.println("mailto: " + recipientEmail);
        System.out.println("HOST: " + host);
        System.out.println("PORT: " + port);
        System.out.println("Sending message: " + message);
    }
}
