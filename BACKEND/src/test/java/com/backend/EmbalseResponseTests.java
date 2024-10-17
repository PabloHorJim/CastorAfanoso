package com.backend;

import com.backend.api.model.Embalse;
import com.backend.api.model.EmbalseResponse;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmbalseResponseTests {

    @Test
    public void testGettersAndSetters() {
        Embalse embalse1 = new Embalse(1, "Ambito1", "Embalse1", 1000.0, 1.0, "36.7213028", "-4.4216366", "Provincia1", "CCAA1", "Tipo1", "Cota1", "Altura1");
        List<Embalse> embalses = Arrays.asList(embalse1);
        EmbalseResponse response = new EmbalseResponse();

        response.setItems(embalses);
        assertEquals(embalses, response.getItems());

        response.setNext("nextPageUrl");
        assertEquals("nextPageUrl", response.getNext());
    }
}
