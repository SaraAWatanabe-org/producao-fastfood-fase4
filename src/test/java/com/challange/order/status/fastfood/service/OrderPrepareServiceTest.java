package com.challange.order.status.fastfood.service;

import com.challange.order.status.fastfood.config.Exception.StatusException;
import com.challange.order.status.fastfood.repository.LunchRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.net.http.HttpClient;
import java.util.Optional;

import static com.challange.order.status.fastfood.utils.TestUtils.buildLunchMock;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderPrepareServiceTest {

    @InjectMocks
    OrderPrepareService service;

    @Mock
    LunchRepository lunchRepository;

    @Mock
    HttpClient httpClient;

    final Long LUNCH_ID = 1L;
    final String NEW_STATUS = "Pronto";

    @BeforeEach
    void setUp() {
        ReflectionTestUtils.setField(service, "productionServiceUrl", "http://mocked-url.com");
    }

    @Test
    @DisplayName("Should throw Status Exception when status is null")
    void updateLunchStatus_shouldThrowPaymentExceptionWhenStatusIsNull() {
        assertThrows(StatusException.class, () -> service.editLunchStatus(LUNCH_ID, null), "Status cannot be null or empty");
    }

    @Test
    @DisplayName("Should throw Status Exception when not found Lunch by id")
    void updateLunchStatus_shouldThrowPaymentExceptionWhenNotFoundLunchById() {
        assertThrows(StatusException.class, () -> service.editLunchStatus(null, NEW_STATUS), "Lunch not found for id: "+LUNCH_ID);
    }

    @Test
    @DisplayName("Should throw RuntimeException when save operation has failed")
    void updateLunchStatus_shouldThrowRuntimeExceptionWhenSaveOperationHasFailed() {
        var lunch = Optional.of(buildLunchMock());

        when(lunchRepository.findById(LUNCH_ID)).thenReturn(lunch);
        when(lunchRepository.save(lunch.get())).thenThrow(RuntimeException.class);

        assertThrows(RuntimeException.class, () -> service.editLunchStatus(LUNCH_ID, NEW_STATUS), "Pagamento não foi efetuado!");
    }

    @Test
    @DisplayName("Should call httpRequestOrderLunch and throw RuntimeException")
    void updateLunchStatus_shouldCallHttpRequestOrderLunchMethodAndThrowRuntimeException() {
        var lunch = Optional.of(buildLunchMock());

        when(lunchRepository.findById(LUNCH_ID)).thenReturn(lunch);
        when(lunchRepository.save(lunch.get())).thenReturn(lunch.get());

        assertThrows(RuntimeException.class, () -> service.editLunchStatus(LUNCH_ID, NEW_STATUS), "Pagamento não foi efetuado!");
    }

    @Test
    @DisplayName("Should edit a Lunch")
    void updateLunchStatus_shouldEditLunch() {
        var lunch = Optional.of(buildLunchMock());

        when(lunchRepository.findById(LUNCH_ID)).thenReturn(lunch);

        assertDoesNotThrow(() -> service.editLunchStatus(LUNCH_ID, NEW_STATUS), "Pagamento não foi efetuado!");
    }

    @Test
    @DisplayName("Should prepare lunch")
    void prepareLunch_shouldEditLunch() {
        var lunch = buildLunchMock();

        assertDoesNotThrow(() -> service.prepareLunch(lunch));
    }

    @Test
    @DisplayName("Should throw RuntimeException when save has failed")
    void prepareLunch_shouldThrowRuntimeExceptionWhenSaveHasFailed() {
        var lunch = buildLunchMock();

        when(lunchRepository.save(lunch)).thenThrow(RuntimeException.class);

        assertThrows(RuntimeException.class, () -> service.prepareLunch(lunch));
    }

}
