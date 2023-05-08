
# Notification Service

Spring boot application that provides message broker (rabbitMQ) for saving order notification.

## Configuration

1. login to Mysql server (change credentials in [application.yml](src/main/resources/application.yml))
2. create DB schema named **notification_db**
3. login to [rabbitMQ](http://localhost:15672/) message broker  (default rabbitMQ credentials)
4. create queue named **vine.queue**

## Service Requirements

Requires:
- a running [Eureka registry](https://github.com/Volodymyr2907/vine-registration-service);
- a running RabbitMQ broker;
- a running Mysql DB;
- a running [user service](https://github.com/Volodymyr2907/user-service) (for interacting with permission)
- a running [vine service](https://github.com/Volodymyr2907/vine-service) (for creating order and publish events)

## How to run

1. run [docker-compose](src/main/resources/docker/docker-compose.yml) file for MySql and RabbitMq
2. ```bash mvn clean install```
3. run [Eureka registry](https://github.com/Volodymyr2907/vine-registration-service);
4. run [notification service](src/main/java/com/mentorship/notificationservice/NotificationServiceApplication.java)
