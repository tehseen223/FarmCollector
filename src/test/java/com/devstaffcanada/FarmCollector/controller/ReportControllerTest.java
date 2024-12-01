package com.devstaffcanada.FarmCollector.controller;

import com.devstaffcanada.FarmCollector.dto.CropReport;
import com.devstaffcanada.FarmCollector.dto.FarmReport;
import com.devstaffcanada.FarmCollector.service.ReportService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ReportController.class)
class ReportControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReportService reportService;

    @Test
    void testGetFarmReport() throws Exception {
        FarmReport report = new FarmReport("MyFarm", "Spring2024", List.of(
                new CropReport("Corn", 20, 18),
                new CropReport("Potatoes", 15, 16)
        ));

        Mockito.when(reportService.getReportByFarm("MyFarm", "Spring2024")).thenReturn(report);

        mockMvc.perform(get("/api/v1/reports/farm/MyFarm")
                        .param("season", "Spring2024"))
                .andExpect(status().isOk());
    }
}

