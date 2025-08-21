package com.marakicode.springstore.ioc;

import org.springframework.stereotype.Component;

//@Component("sms")
public class SMSService implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}
