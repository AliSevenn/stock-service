package com.alis.stockservice.controller;

import com.alis.stockservice.TestMain;
import com.alis.stockservice.model.Category;
import com.alis.stockservice.model.Product;
import com.alis.stockservice.model.request.ProductQueryRequest;
import com.alis.stockservice.model.response.ProductQueryResponse;
import com.alis.stockservice.service.CategoryService;
import com.alis.stockservice.service.ProductService;
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
public class ProductControllerTest {
    @Autowired
    UserService userService;
    Long categoryId;
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @Transactional
    @DisplayName("Test Query Product SuccessFully")
    void testQueryProductSuccessFully() throws JsonProcessingException, Exception {

        Category category = new Category();
        category.setModifyUser("alis");
        category.setName("book");
        category.setCreateTime(LocalDateTime.now());
        category = categoryService.save(category);

        Product product = new Product();
        product.setModifyUser("alis");
        product.setPrice(BigDecimal.TEN);
        product.setCategory(category);
        product.setName("1984");
        product.setCreateTime(LocalDateTime.now());

        product = productService.save(product);
        var query = new ProductQueryRequest(List.of(product.getProductId()), List.of(product.getName()));


        var res = mockMvc
                .perform(
                        post("/product/query").contentType("application/json")
                                .content(objectMapper.writeValueAsString(query)))
                .andDo(print()).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        ProductQueryResponse result = objectMapper.readValue(res, ProductQueryResponse.class);
        assertTrue(result.getProductIds().size() > 0);

    }


}
