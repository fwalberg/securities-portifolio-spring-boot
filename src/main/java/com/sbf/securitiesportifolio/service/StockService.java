package com.sbf.securitiesportifolio.service;

import com.sbf.securitiesportifolio.model.Stock;

public interface StockService {

    Stock findById(Integer id);

    Stock create(Stock stock);
}
