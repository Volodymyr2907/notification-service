package com.mentorship.notificationservice.event.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderEvent implements Serializable {

    private Long orderId;
    private OrderStatus orderStatus;


    public enum OrderStatus {
        CREATED,
        PENDING
    }
}
