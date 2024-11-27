package com.challange.order.status.fastfood.controller.request;

import com.challange.order.status.fastfood.model.enums.LunchStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class LunchRequest {

    private Client client;
    private double priceTotal;
    private LunchStatus status;
    private Long id;
    private LocalDateTime date;

}
