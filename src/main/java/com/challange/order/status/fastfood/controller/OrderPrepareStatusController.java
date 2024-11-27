package com.challange.order.status.fastfood.controller;


import com.challange.order.status.fastfood.controller.request.LunchRequest;
import com.challange.order.status.fastfood.mapstruct.LunchMapper;
import com.challange.order.status.fastfood.model.Lunch;
import com.challange.order.status.fastfood.service.OrderPrepareService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prepare")
@Tag(name = "Lunch", description = "Lunch Controller")
@RequiredArgsConstructor
public class OrderPrepareStatusController {

    private final OrderPrepareService orderPrepareStatus;

    private final LunchMapper lunchMapper;


    @PostMapping
    @Operation(summary = "Create a lunch order", description = "Prepare a lunch order")
    public ResponseEntity prepareLunch(@RequestBody LunchRequest lunchRequest) {
        Lunch lunch = lunchMapper.LunchRequestToLunch(lunchRequest);
        Lunch createdLunch = orderPrepareStatus.prepareLunch(lunch);

        return ResponseEntity.ok(createdLunch);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Lunch> updateLunchStatus(@PathVariable("id") Long lunchId,@RequestParam("status") String newStatus) {
        try {
            Lunch updatedLunch = orderPrepareStatus.editLunchStatus(lunchId, newStatus);
            return ResponseEntity.ok(updatedLunch);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }


}
