package com.challange.order.status.fastfood.model;

import com.challange.order.status.fastfood.model.enums.LunchStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class LunchTest {

    @Test
    public void testSetAndGetId() {
        Lunch lunch = new Lunch();
        Long expectedId = 1L;

        lunch.setId(expectedId);
        assertEquals(expectedId, lunch.getId(), "O ID retornado não corresponde ao esperado.");
    }

    @Test
    public void testSetAndGetClientCPF() {
        Lunch lunch = new Lunch();
        String expectedCPF = "123.456.789-00";

        lunch.setClientCPF(expectedCPF);
        assertEquals(expectedCPF, lunch.getClientCPF(), "O CPF retornado não corresponde ao esperado.");
    }

    @Test
    public void testSetAndGetPriceTotal() {
        Lunch lunch = new Lunch();
        double expectedPrice = 50.75;

        lunch.setPriceTotal(expectedPrice);
        assertEquals(expectedPrice, lunch.getPriceTotal(), "O preço total retornado não corresponde ao esperado.");
    }

    @Test
    public void testSetAndGetStatus() {
        Lunch lunch = new Lunch();
        LunchStatus expectedStatus = LunchStatus.EM_PREPARACAO;

        lunch.setStatus(expectedStatus);
        assertEquals(expectedStatus, lunch.getStatus(), "O status retornado não corresponde ao esperado.");
    }

    @Test
    public void testSetAndGetDate() {
        Lunch lunch = new Lunch();
        LocalDateTime expectedDate = LocalDateTime.now();

        lunch.setDate(expectedDate);
        assertEquals(expectedDate, lunch.getDate(), "A data retornada não corresponde ao esperado.");
    }

    @Test
    public void testDefaultValuesAreNull() {
        Lunch lunch = new Lunch();

        assertNull(lunch.getId(), "O ID inicial deveria ser nulo.");
        assertNull(lunch.getClientCPF(), "O CPF inicial deveria ser nulo.");
        assertEquals(0.0, lunch.getPriceTotal(), "O preço total inicial deveria ser 0.0.");
        assertNull(lunch.getStatus(), "O status inicial deveria ser nulo.");
        assertNull(lunch.getDate(), "A data inicial deveria ser nula.");
    }

}
