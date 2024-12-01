package com.challange.order.status.fastfood.model.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class LunchStatusTest {

    @Test
    @DisplayName("Should return correct description for each enum value")
    void testGetDescricao() {
        assertEquals("Recebido", LunchStatus.RECEBIDO.getDescricao());
        assertEquals("Em Preparação", LunchStatus.EM_PREPARACAO.getDescricao());
        assertEquals("Pronto", LunchStatus.PRONTO.getDescricao());
        assertEquals("Finalizado", LunchStatus.FINALIZADO.getDescricao());
    }

    @Test
    @DisplayName("Should return correct LunchStatus for valid descriptions")
    void testFromDescricaoWithValidValues() {
        assertEquals(LunchStatus.RECEBIDO, LunchStatus.fromDescricao("Recebido"));
        assertEquals(LunchStatus.EM_PREPARACAO, LunchStatus.fromDescricao("Em Preparação"));
        assertEquals(LunchStatus.PRONTO, LunchStatus.fromDescricao("Pronto"));
        assertEquals(LunchStatus.FINALIZADO, LunchStatus.fromDescricao("Finalizado"));
    }

    @Test
    @DisplayName("Should return correct LunchStatus for case-insensitive descriptions")
    void testFromDescricaoWithCaseInsensitiveValues() {
        assertEquals(LunchStatus.RECEBIDO, LunchStatus.fromDescricao("recebido"));
        assertEquals(LunchStatus.EM_PREPARACAO, LunchStatus.fromDescricao("em preparação"));
        assertEquals(LunchStatus.PRONTO, LunchStatus.fromDescricao("pronto"));
        assertEquals(LunchStatus.FINALIZADO, LunchStatus.fromDescricao("finalizado"));
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException for invalid descriptions")
    void testFromDescricaoWithInvalidValues() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                LunchStatus.fromDescricao("Inexistente")
        );
        assertEquals("Status não reconhecido: Inexistente", exception.getMessage());
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException for null description")
    void testFromDescricaoWithNullValue() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                LunchStatus.fromDescricao(null)
        );
        assertEquals("Status não reconhecido: null", exception.getMessage());
    }

}
