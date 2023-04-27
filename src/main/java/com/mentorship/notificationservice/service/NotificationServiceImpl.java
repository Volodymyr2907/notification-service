package com.mentorship.notificationservice.service;

import com.mentorship.notificationservice.domain.Notification;
import com.mentorship.notificationservice.event.model.OrderEvent;
import com.mentorship.notificationservice.repository.NotificationRepository;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class NotificationServiceImpl {

    private final NotificationRepository notificationRepository;

    @RabbitListener(queues = "${spring.rabbitmq.template.default-receive-queue}")
    public void saveNotificationFromQueue(OrderEvent object) {

        Notification notification = new Notification();
        notification.setMessage(object.getMessage());
        notification.setOrderId(object.getOrderId());
        notification.setDate(LocalDateTime.now());

        notificationRepository.save(notification);

    }
}
