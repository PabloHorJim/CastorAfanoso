package com.backend;

import com.backend.api.model.Embalse;
import com.backend.service.EmbalseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmbalseServiceTests {

    @BeforeEach
    void setUp() {
        // Set up mock data for testing
        Embalse embalse1 = Mockito.mock(Embalse.class);
        Mockito.when(embalse1.getX()).thenReturn("36.7213028");
        Mockito.when(embalse1.getY()).thenReturn("-4.4216366");

        Embalse embalse2 = Mockito.mock(Embalse.class);
        Mockito.when(embalse2.getX()).thenReturn("40.4167754");
        Mockito.when(embalse2.getY()).thenReturn("-3.7037902");

        List<Embalse> mockEmbalses = Arrays.asList(embalse1, embalse2);
        EmbalseService.setEmbalses(mockEmbalses);
    }

    @Test
    void testCalcularDistanciaDouble() {
        double latA = 36.7213028;
        double lonA = -4.4216366;
        double latB = 40.4167754;
        double lonB = -3.7037902;

        double expectedDistance = 415.72; // approximate distance in km
        double actualDistance = EmbalseService.calcularDistancia(latA, lonA, latB, lonB);

        assertEquals(expectedDistance, actualDistance, 1.0); // Allow a small tolerance
    }

    @Test
    void testCalcularDistanciaString() {
        String latA = "36.7213028";
        String lonA = "-4.4216366";
        String latB = "40.4167754";
        String lonB = "-3.7037902";

        double expectedDistance = 415.72; // approximate distance in km
        double actualDistance = EmbalseService.calcularDistancia(
                Double.parseDouble(latA),
                Double.parseDouble(lonA),
                Double.parseDouble(latB),
                Double.parseDouble(lonB)
        );

        assertEquals(expectedDistance, actualDistance, 1.0); // Allow a small tolerance
    }

    @Test
    void testGetFromDist() {
        List<Embalse> embalses = EmbalseService.getFromDist("36.7213028", "-4.4216366", 500);
        assertEquals(1, embalses.size()); // Only one embalse should be within 500 km

        embalses = EmbalseService.getFromDist("36.7213028", "-4.4216366", 100);
        assertEquals(0, embalses.size()); // No embalses should be within 100 km
    }

    @Test
    void testGetDemarcaciones() {
        List<String> demarcaciones = EmbalseService.getDemarcaciones();
        assertEquals(2, demarcaciones.size()); // Expect 2 different demarcations
    }
}
