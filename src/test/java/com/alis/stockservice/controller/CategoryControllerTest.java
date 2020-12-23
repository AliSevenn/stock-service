package com.alis.stockservice.controller;

import com.alis.stockservice.TestMain;
import com.alis.stockservice.model.Category;
import com.alis.stockservice.model.request.CategoryQueryRequest;
import com.alis.stockservice.model.response.CategoryQueryResponse;
import com.alis.stockservice.service.CategoryService;
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
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = TestMain.class)
@AutoConfigureMockMvc
@TestInstance(Lifecycle.PER_CLASS)
@Transactional
public class CategoryControllerTest {
    @Autowired
    UserService userService;
    @Autowired
    CategoryService categoryService;
    Long categoryId;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Test Query Category SuccessFully")
    void testQueryCategorySuccessFully() throws JsonProcessingException, Exception {
        Category category = new Category();
        category.setModifyUser("alis");
        category.setName("book");
        category.setModifyTime(LocalDateTime.now());
        category = categoryService.save(category);
        var query = new CategoryQueryRequest(List.of((category.getCategoryId())), List.of(category.getName()));


        var res = mockMvc
                .perform(post("/category/query").contentType("application/json")
                        .content(objectMapper.writeValueAsString(query)))
                .andDo(print()).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        CategoryQueryResponse result = objectMapper.readValue(res, CategoryQueryResponse.class);
        assertTrue(result.getCategories().size() > 0);

    }
}
