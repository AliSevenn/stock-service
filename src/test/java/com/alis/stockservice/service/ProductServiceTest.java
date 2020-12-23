package com.alis.stockservice.service;

import com.alis.stockservice.TestMain;
import com.alis.stockservice.entity.CategoryEntity;
import com.alis.stockservice.model.Category;
import com.alis.stockservice.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = TestMain.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProductServiceTest {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    CategoryEntity category;

    @DisplayName("Test save product")
    @Test
    void testSaveProduct() {

        Category category = new Category();
        category.setModifyUser("alis");
        category.setName("book");
        category.setModifyTime(LocalDateTime.now());
        category = categoryService.save(category);

        Product product = new Product();
        product.setModifyUser("alis");
        product.setName("pen");
        product.setPrice(BigDecimal.TEN);
        product.setCategory(category);

        productService.save(product);
        assertTrue(productService.save(product).getProductId() > 0);
    }

    @DisplayName("Test find product")
    @Test
    @Transactional
    void testFindProduct() {

        Category category = new Category();
        category.setModifyUser("alis");
        category.setName("book");
        category.setModifyTime(LocalDateTime.now());
        category = categoryService.save(category);

        Product product = new Product();
        product.setModifyUser("alis");
        product.setName("pen");
        product.setPrice(BigDecimal.TEN);
        product.setCategory(category);
        product = productService.save(product);


        assertTrue(productService.findById(product.getProductId()).getProductId() > 1);
    }

    @DisplayName("Test find product by name and id")
    @Test
    @Transactional
    void testFindByProductNameAndId() {
        Category category = new Category();
        category.setModifyUser("alis");
        category.setName("book");
        category.setModifyTime(LocalDateTime.now());
        category = categoryService.save(category);

        Product product = new Product();
        product.setModifyUser("alis");
        product.setName("pen");
        product.setPrice(BigDecimal.TEN);
        product.setCategory(category);
        product = productService.save(product);

        assertTrue(productService.query(List.of(product.getProductId()), List.of("pen")).size() > 0);
    }


}
