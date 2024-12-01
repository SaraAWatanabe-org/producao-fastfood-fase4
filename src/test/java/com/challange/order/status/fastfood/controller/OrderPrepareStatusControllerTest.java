package com.challange.order.status.fastfood.controller;

import com.challange.order.status.fastfood.controller.request.LunchRequest;
import com.challange.order.status.fastfood.mapstruct.LunchMapper;
import com.challange.order.status.fastfood.model.Lunch;
import com.challange.order.status.fastfood.service.OrderPrepareService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderPrepareStatusControllerTest {

    @InjectMocks
    private OrderPrepareStatusController controller;

    @Mock
    private OrderPrepareService orderPrepareStatus;

    @Mock
    private LunchMapper lunchMapper;

    private LunchRequest lunchRequest;
    private Lunch lunch;

    @Test
    @DisplayName("Should create a lunch order")
    void testPrepareLunch() {
        lunchRequest = new LunchRequest();
        lunch = new Lunch();
        ResponseEntity<?> response = controller.prepareLunch(lunchRequest);
        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
    }

    @Test
    @DisplayName("Should update lunch status")
    void testUpdateLunchStatus() {
        lunchRequest = new LunchRequest();
        lunch = new Lunch();
        Long lunchId = 1L;
        String newStatus = "Pronto";

        ResponseEntity<Lunch> response = controller.updateLunchStatus(lunchId, newStatus);

        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
    }

    @Test
    @DisplayName("Should return bad request for invalid status update")
    void testUpdateLunchStatusInvalid() {
        lunchRequest = new LunchRequest();
        lunch = new Lunch();
        Long lunchId = 1L;
        String newStatus = "InvalidStatus";

        when(orderPrepareStatus.editLunchStatus(any(), any())).thenThrow(IllegalArgumentException.class);

        ResponseEntity<Lunch> response = controller.updateLunchStatus(lunchId, newStatus);

        assertNotNull(response);
        assertEquals(400, response.getStatusCode().value());
        assertNull(response.getBody());
    }

}
