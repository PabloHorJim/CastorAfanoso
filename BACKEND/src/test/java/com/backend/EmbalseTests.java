package com.backend;

import com.backend.api.model.Embalse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmbalseTests {

    @Test
    public void testEmbalseGettersAndSetters() {
        Embalse embalse = new Embalse(1, "Ambito1", "Embalse1", 1000.0, 1.0, "36.7213028", "-4.4216366", "Provincia1", "CCAA1", "Tipo1", "Cota1", "Altura1");

        assertEquals(1, embalse.getId());
        assertEquals("Ambito1", embalse.getAmbito_nombre());
        assertEquals("Embalse1", embalse.getEmbalse_nombre());
        assertEquals(1000.0, embalse.getAgua_total());
        assertEquals("36.7213028", embalse.getX());
        assertEquals("Provincia1", embalse.getProvincia());
    }
}
