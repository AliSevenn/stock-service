package com.alis.stockservice.controller;

import com.alis.stockservice.TestMain;
import com.alis.stockservice.entity.*;
import com.alis.stockservice.model.Category;
import com.alis.stockservice.model.Product;
import com.alis.stockservice.model.request.StockQueryRequest;
import com.alis.stockservice.model.response.StockQueryResponse;
import com.alis.stockservice.service.*;
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
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = TestMain.class)
@AutoConfigureMockMvc
@TestInstance(Lifecycle.PER_CLASS)
public class StockControllerTest {
    @Autowired
    UserService userService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    StockService stockService;
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
    @DisplayName("Test Query Stock SuccessFully")
    void testQueryStockSuccessFully() throws JsonProcessingException, Exception {

        Category category = new Category();
        category.setModifyUser("alis");
        category.setName("book");
        category = categoryService.save(category);

        Product product = new Product();
        product.setModifyUser("alis");
        product.setPrice(BigDecimal.TEN);
        product.setCategory(category);
        product.setName("1984");
        product.setCreateTime(LocalDateTime.now());
        product = productService.save(product);

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

        StockEntity stock = new StockEntity();
        stock.setProduct(productService.findByProductId(product.getProductId()));
        stock.setName("stock1");
        stock.setStore(store);
        stock = stockService.save(stock);

        var query = new StockQueryRequest(List.of(stock.getProduct().getProductId()),
                List.of(stock.getStore().getStoreId()));

        var res = mockMvc
                .perform(post("/stock/query").contentType("application/json")
                        .content(objectMapper.writeValueAsString(query)))
                .andDo(print()).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        StockQueryResponse result = objectMapper.readValue(res, StockQueryResponse.class);
        assertTrue(result.getStocks().size() > 0);
    }


}
