package com.challange.order.status.fastfood.controller.request;

import com.challange.order.status.fastfood.model.enums.LunchStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class LunchRequestTest {

    @Test
    public void testSetAndGetClient() {
        LunchRequest lunchRequest = new LunchRequest();
        Client client = new Client();
        client.setCpf("123.456.789-00");

        lunchRequest.setClient(client);
        Client actualClient = lunchRequest.getClient();

        assertEquals(client, actualClient, "O cliente retornado não corresponde ao esperado.");
    }

    @Test
    public void testSetAndGetPriceTotal() {
        LunchRequest lunchRequest = new LunchRequest();
        double expectedPriceTotal = 100.50;

        lunchRequest.setPriceTotal(expectedPriceTotal);
        double actualPriceTotal = lunchRequest.getPriceTotal();

        assertEquals(expectedPriceTotal, actualPriceTotal, "O preço total retornado não corresponde ao esperado.");
    }

    @Test
    public void testSetAndGetStatus() {
        LunchRequest lunchRequest = new LunchRequest();
        LunchStatus expectedStatus = LunchStatus.EM_PREPARACAO;

        lunchRequest.setStatus(expectedStatus);
        LunchStatus actualStatus = lunchRequest.getStatus();

        assertEquals(expectedStatus, actualStatus, "O status retornado não corresponde ao esperado.");
    }

    @Test
    public void testSetAndGetId() {
        LunchRequest lunchRequest = new LunchRequest();
        Long expectedId = 123L;

        lunchRequest.setId(expectedId);
        Long actualId = lunchRequest.getId();

        assertEquals(expectedId, actualId, "O ID retornado não corresponde ao esperado.");
    }

    @Test
    public void testSetAndGetDate() {
        LunchRequest lunchRequest = new LunchRequest();
        LocalDateTime expectedDate = LocalDateTime.now();

        lunchRequest.setDate(expectedDate);
        LocalDateTime actualDate = lunchRequest.getDate();

        assertEquals(expectedDate, actualDate, "A data retornada não corresponde ao esperado.");
    }

    @Test
    public void testDefaultValuesAreNull() {
        LunchRequest lunchRequest = new LunchRequest();

        assertNull(lunchRequest.getClient(), "O cliente inicial deveria ser nulo.");
        assertNull(lunchRequest.getStatus(), "O status inicial deveria ser nulo.");
        assertNull(lunchRequest.getId(), "O ID inicial deveria ser nulo.");
        assertNull(lunchRequest.getDate(), "A data inicial deveria ser nula.");
        assertEquals(0.0, lunchRequest.getPriceTotal(), "O preço total inicial deveria ser 0.0.");
    }
}
