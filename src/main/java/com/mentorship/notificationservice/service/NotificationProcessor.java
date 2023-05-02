package com.mentorship.notificationservice.service;

import com.mentorship.notificationservice.domain.Notification;
import com.mentorship.notificationservice.event.model.OrderEvent;
import com.mentorship.notificationservice.repository.NotificationRepository;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Transactional
@RequiredArgsConstructor
public class NotificationProcessor {

    private final NotificationRepository notificationRepository;

    @RabbitListener(queues = "${spring.rabbitmq.template.default-receive-queue}")
    public void saveNotificationFromQueue(OrderEvent event) {

        Notification notification = new Notification();
        notification.setMessage(event.getMessage());
        notification.setOrderId(event.getOrderId());
        notification.setDate(LocalDateTime.now());

        notificationRepository.save(notification);

    }
}
