package com.alis.stockservice.rest.service;

import com.alis.stockservice.model.Product;
import com.alis.stockservice.model.request.ProductQueryRequest;
import com.alis.stockservice.model.response.ProductQueryResponse;
import com.alis.stockservice.service.CategoryService;
import com.alis.stockservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ProductBusinessService {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;


    public ProductQueryResponse query(ProductQueryRequest request) {
        var products = productService.query(request.getProductIds(), request.getNames());
        var response = new ProductQueryResponse(new ArrayList<Long>());

        products.forEach(p->{

            response.getProductIds().add(p.getProductId());

        });

        return response;
    }

}
