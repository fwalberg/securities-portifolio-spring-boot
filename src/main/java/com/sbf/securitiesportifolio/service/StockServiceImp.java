package com.sbf.securitiesportifolio.service;

import com.sbf.securitiesportifolio.model.Stock;
import com.sbf.securitiesportifolio.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class StockServiceImp implements StockService {

    private final StockRepository repository;

    @Override
    public Stock findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Stock create(Stock stock) {
        if (repository.existsById(stock.getId())) {
           throw new IllegalArgumentException("Stock with id " + stock.getId() + " already exists");
        }
        return null;
    }
}
