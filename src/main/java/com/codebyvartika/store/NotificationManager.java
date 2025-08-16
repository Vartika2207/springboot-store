package com.codebyvartika.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.management.Notification;

@Service
public class NotificationManager {
    NotificationService notificationService;
    @Autowired
    public NotificationManager(NotificationService notificationService) {
        this.notificationService = notificationService;
        System.out.println("---- NotificationManager ------");
    }

    public void sendNotification(String message) {
        String text = "Order Placed";
        notificationService.send(message);
    }
}
