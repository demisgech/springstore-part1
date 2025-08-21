package com.marakicode.springstore;

import com.marakicode.springstore.ioc.*;
import com.marakicode.springstore.ioc.exercise.User;
import com.marakicode.springstore.ioc.exercise.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringstoreApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringstoreApplication.class, args);

        var orderService = context.getBean(OrderService.class);
        orderService.placeOrder(new Order());

        var orderService2 = context.getBean(OrderService.class);
        orderService2.placeOrder(new Order());

//        var notificationManager = context.getBean(NotificationManager.class);
//        notificationManager.sendNotification("Test Notification");

//        var taxReport = context.getBean(TaxReport.class);
//        var tax = taxReport.calculateTax(100,0.2);
//        System.out.println("Tax: " + tax);
//        var heavyResource = context.getBean(HeavyResource.class);

        var userService = context.getBean(UserService.class);
        userService.register(new User(1L,"Yohannis","yohannis@domain.com","12345"));
        userService.register(new User(2L,"Yohannis","yohannis@domain.com","12345"));

        context.close();
    }

}
