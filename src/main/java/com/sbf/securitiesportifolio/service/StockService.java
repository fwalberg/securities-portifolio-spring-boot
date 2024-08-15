package com.sbf.securitiesportifolio.service;

import com.sbf.securitiesportifolio.model.Stock;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface StockService {

    Optional<Stock> getStockById(Integer id);
    List<Stock> getStockByCompanyName(String companyName);
    Optional<Stock> getStockByTickerSymbol(String tickerSymbol);
    List<Stock> getAllStocks();
    List<Stock> getStockByRangeOfDate(LocalDate startDate, LocalDate endDate);

    Stock createStock(Stock stock);

    Stock updateStock(Stock stock);

    void deleteStockById(Integer id);

}
