package com.backend;

import com.backend.api.controller.EmbalseController;
import com.backend.api.model.Embalse;
import com.backend.service.EmbalseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmbalseController.class)
public class EmbalseControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmbalseService embalseService;

    @BeforeEach
    void setUp() {
        Embalse embalse1 = new Embalse(1, "Ambito1", "Embalse1", 1000.0, 1.0, "36.7213028", "-4.4216366", "Provincia1", "CCAA1", "Tipo1", "Cota1", "Altura1");
        List<Embalse> embalses = Arrays.asList(embalse1);

        Mockito.when(embalseService.getFromDist("36.7213028", "-4.4216366", 500)).thenReturn(embalses);
    }

    @Test
    public void testGetFromLocalization() throws Exception {
        mockMvc.perform(get("/?x=36.7213028&y=-4.4216366&dist=500"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(1));
    }

    @Test
    public void testGetDemarcaciones() throws Exception {
        Mockito.when(embalseService.getDemarcaciones()).thenReturn(Arrays.asList("Demarcacion1", "Demarcacion2"));

        mockMvc.perform(get("/Cuenca"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2));
    }
}
