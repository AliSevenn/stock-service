package com.alis.stockservice.service;

import com.alis.stockservice.TestMain;
import com.alis.stockservice.model.Category;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = TestMain.class)
public class CategoryServiceTest {

    @Autowired
    CategoryService categoryService;

    @DisplayName("Test save category")
    @Test
    @Transactional
    void testSaveCategory() {

        Category category = new Category();
        category.setModifyUser("alis");
        category.setName("book");
        Long categoryId = categoryService.save(category).getCategoryId();


        assertTrue(categoryId > 0);
    }

    @DisplayName("Test find category")
    @Test
    @Transactional
    void testFindCategory() {
        Category category = new Category();
        category.setModifyUser("alis");
        category.setName("pen");
        Long categoryId = categoryService.save(category).getCategoryId();
        assertTrue(Optional.of(categoryService.findById(categoryId)).isPresent());
    }

    @DisplayName("Test find category by name and id")
    @Test
    @Transactional
    void testFindByCategoryNameAndId() {
        Category category = new Category();
        category.setModifyUser("alis");
        category.setName("pen");
        Long categoryId = categoryService.save(category).getCategoryId();
        assertTrue(categoryService.query(List.of(categoryId), List.of("pen")).size() > 0);
    }


}
