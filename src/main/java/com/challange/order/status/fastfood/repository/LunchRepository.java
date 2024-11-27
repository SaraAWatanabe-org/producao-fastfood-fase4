package com.challange.order.status.fastfood.repository;

import com.challange.order.status.fastfood.model.Lunch;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LunchRepository extends MongoRepository<Lunch, Long> {

}