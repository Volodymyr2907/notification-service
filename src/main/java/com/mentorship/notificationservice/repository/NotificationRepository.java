package com.mentorship.notificationservice.repository;

import com.mentorship.notificationservice.domain.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NotificationRepository extends JpaRepository<Notification, Long>,
    JpaSpecificationExecutor<Notification> {

}
