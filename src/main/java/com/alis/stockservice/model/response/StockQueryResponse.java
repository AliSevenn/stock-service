package com.alis.stockservice.model.response;

import java.util.List;

import com.alis.stockservice.model.Stock;

public class StockQueryResponse {
	private List<Stock> stocks;

	public List<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	public StockQueryResponse(List<Stock> stocks) {
		this.stocks = stocks;
	}

	public StockQueryResponse() {
	}
}
