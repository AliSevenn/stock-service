package com.alis.stockservice.rest.service;

import com.alis.stockservice.entity.StockEntity;
import com.alis.stockservice.model.Product;
import com.alis.stockservice.model.Stock;
import com.alis.stockservice.model.Store;
import com.alis.stockservice.model.request.StockQueryRequest;
import com.alis.stockservice.model.response.StockQueryResponse;
import com.alis.stockservice.service.ProductService;
import com.alis.stockservice.service.StockService;
import com.alis.stockservice.service.StoreService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class StockBusinessService {

    @Autowired
    StockService stockService;

    @Autowired
    StoreService storeService;

    @Autowired
    ProductService productService;
    @Autowired
    ModelMapper modelMapper;

    public StockQueryResponse query(StockQueryRequest request) {
        var stocks = stockService.query(request.getProductIds(), request.getStoreIds());
        var response = new StockQueryResponse(new ArrayList<Stock>());
        //response.setStocks(new ArrayList<Stock>());
        stocks.forEach(s -> {
            var stock = new Stock();
            stock.setName(s.getName());
            stock.setStockId(s.getStockId());
            stock.setStore(modelMapper.map(s.getStore(),Store.class));
            stock.setProduct(modelMapper.map(s.getProduct(), Product.class));
            response.getStocks().add(stock);


            


        });

        return response;
    }

}
