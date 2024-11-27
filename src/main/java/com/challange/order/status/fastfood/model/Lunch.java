package com.challange.order.status.fastfood.model;

import com.challange.order.status.fastfood.model.enums.LunchStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Document(collection = "lunch")
public class Lunch {

    @Id
    private Long id;
    private String clientCPF;
    private double priceTotal;
    private LunchStatus status;
    @CreatedDate
    private LocalDateTime date;
}
