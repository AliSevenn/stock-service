package com.alis.stockservice.controller;

import com.alis.stockservice.TestMain;
import com.alis.stockservice.entity.AddressEntity;
import com.alis.stockservice.entity.RegionEntity;
import com.alis.stockservice.entity.RegionType;
import com.alis.stockservice.entity.StoreEntity;
import com.alis.stockservice.model.request.StoreQueryRequest;
import com.alis.stockservice.model.response.StoreQueryResponse;
import com.alis.stockservice.service.AddressService;
import com.alis.stockservice.service.RegionService;
import com.alis.stockservice.service.StoreService;
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
public class StoreControllerTest {
	@Autowired
	UserService userService;
	Long categoryId;
	@Autowired
	RegionService regionService;
	@Autowired
	AddressService addressService;
	@Autowired
	StoreService storeService;
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;

	@Test
	@Transactional
	@DisplayName("Test Query Store SuccessFully")
	void testQueryStoreSuccessFully() throws JsonProcessingException, Exception {

		RegionEntity region = new RegionEntity();
		region.setName("kadikoy");
		region.setPostalCode(3400);
		region.setRegionType(RegionType.CITY);
		region = regionService.save(region);

		AddressEntity address = new AddressEntity();
		address.setCountry("izmir");
		address.setDescription("nees");
		address.setRegion(region);
		address = addressService.save(address);

		StoreEntity store = new StoreEntity();
		store.setAddress(address);
		store.setRegion(region);
		store.setName("kadikoy");

		store = storeService.save(store);
		var query = new StoreQueryRequest(List.of((store.getStoreId())), List.of(store.getRegion().getRegionId()));

		var res = mockMvc
				.perform(post("/store/query").contentType("application/json")
						.content(objectMapper.writeValueAsString(query)))
				.andDo(print()).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		StoreQueryResponse result = objectMapper.readValue(res, StoreQueryResponse.class);
		assertTrue(result.getStores().size() > 0);
	}

}
