package com.alis.stockservice.controller;

import com.alis.stockservice.TestMain;
import com.alis.stockservice.entity.RegionEntity;
import com.alis.stockservice.entity.RegionType;
import com.alis.stockservice.model.request.RegionQueryRequest;
import com.alis.stockservice.model.response.RegionQueryResponse;
import com.alis.stockservice.service.RegionService;
import com.alis.stockservice.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = TestMain.class)
@AutoConfigureMockMvc
@TestInstance(Lifecycle.PER_CLASS)
public class RegionControllerTest {
    @Autowired
    UserService userService;
    Long categoryId;
    @Autowired
    RegionService regionService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @Transactional
    @DisplayName("Test Query Region SuccessFully")
    void testQueryRegionSuccessFully() throws JsonProcessingException, Exception {
        RegionEntity region = new RegionEntity();
        region.setName("kadikoy");
        region.setPostalCode(3400);
        region.setRegionType(RegionType.CITY);
        region = regionService.save(region);
        var query = new RegionQueryRequest(List.of(region.getRegionId()), List.of(region.getRegionType()));

        var res = mockMvc
                .perform(post("/region/query").contentType("application/json")
                        .content(objectMapper.writeValueAsString(query)))
                .andDo(print()).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        RegionQueryResponse result = objectMapper.readValue(res, RegionQueryResponse.class);
        assertTrue(result.getRegions().size() > 0);
    }


}
