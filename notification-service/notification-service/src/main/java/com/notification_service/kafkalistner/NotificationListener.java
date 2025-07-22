package com.notification_service.kafkalistner;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {

    @KafkaListener(topics = "enrollment-events",groupId = "notification-group")
    public void handleNotification(String message) {
        System.out.println("Received Notification: " + message);
    }
}
