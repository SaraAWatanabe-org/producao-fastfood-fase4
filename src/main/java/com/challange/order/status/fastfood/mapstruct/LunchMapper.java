package com.challange.order.status.fastfood.mapstruct;

import com.challange.order.status.fastfood.controller.request.LunchRequest;
import com.challange.order.status.fastfood.model.Lunch;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LunchMapper {

    @Mapping(source = "client.cpf", target = "clientCPF")
    Lunch LunchRequestToLunch(LunchRequest lunchRequest);



}
