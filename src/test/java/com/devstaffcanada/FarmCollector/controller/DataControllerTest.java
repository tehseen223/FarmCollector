package com.devstaffcanada.FarmCollector.controller;

import com.devstaffcanada.FarmCollector.dto.HarvestedDataRequest;
import com.devstaffcanada.FarmCollector.dto.PlantedDataRequest;
import com.devstaffcanada.FarmCollector.service.DataService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(DataController.class)
class DataControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DataService dataService;

    @Test
    void testSubmitPlantedData() throws Exception {
        PlantedDataRequest request = new PlantedDataRequest("MyFarm", "Spring2024", "Field1", "Corn", 10, 20);

        mockMvc.perform(post("/api/v1/planted")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(request)))
                .andExpect(status().isCreated());
    }

    @Test
    void testSubmitHarvestedData() throws Exception {
        HarvestedDataRequest request = new HarvestedDataRequest("MyFarm", "Spring2024", "Field1", "Corn", 18);

        mockMvc.perform(post("/api/v1/harvested")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(request)))
                .andExpect(status().isCreated());
    }
}

