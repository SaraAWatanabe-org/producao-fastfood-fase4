package com.challange.order.status.fastfood.controller.request;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class ClientTest {

    @Test
    public void testSetAndGetCpf() {
        Client client = new Client();
        String expectedCpf = "123.456.789-00";

        client.setCpf(expectedCpf);
        String actualCpf = client.getCpf();

        assertEquals(expectedCpf, actualCpf, "O CPF retornado não corresponde ao esperado.");
    }

    @Test
    public void testCpfIsInitiallyNull() {
        Client client = new Client();

        String initialCpf = client.getCpf();

        assertNull(initialCpf, "O CPF inicial deveria ser nulo.");
    }

}
