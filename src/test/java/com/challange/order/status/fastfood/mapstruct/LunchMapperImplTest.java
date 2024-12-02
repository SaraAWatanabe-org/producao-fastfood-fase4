package com.challange.order.status.fastfood.mapstruct;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.challange.order.status.fastfood.utils.TestUtils.buildLunchRequesthMock;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class LunchMapperImplTest {

    @InjectMocks
    LunchMapperImpl mapper;

    @Test
    @DisplayName("Should convert LunchRequest to Lunch")
    void LunchRequestToLunch() {
        var request = buildLunchRequesthMock();

        assertDoesNotThrow(() -> {
            var response = mapper.LunchRequestToLunch(request);
            assertNotNull(response);
        });
    }

    @Test
    @DisplayName("Should return null when request is null")
    void LunchRequestToLunch_error() {
        assertDoesNotThrow(() -> {
            var response = mapper.LunchRequestToLunch(null);
            assertNull(response);
        });
    }

}
