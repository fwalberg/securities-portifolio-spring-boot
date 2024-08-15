package com.sbf.securitiesportifolio.service;

import com.sbf.securitiesportifolio.model.Stock;
import com.sbf.securitiesportifolio.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StockServiceImp implements StockService {

    private final StockRepository stockRepository;

    @Override
    public Optional<Stock> getStockById(Integer id) {
       return Optional.ofNullable(
               stockRepository.findById(id)
                       .orElseThrow(() -> new NoSuchElementException("Stock not found")));
    }

    @Override
    public List<Stock> getStockByCompanyName(String companyName) {
        try {
            return stockRepository.findByCompanyName(companyName);
        } catch (Exception e) {
            throw new NoSuchElementException("Stock not found");
        }
    }

    @Override
    public Optional<Stock> getStockByTickerSymbol(String tickerSymbol) {
        return Optional.ofNullable(
                stockRepository.findByTickerSymbol(tickerSymbol)
                        .orElseThrow(() -> new NoSuchElementException("Stock not found")));
    }

    @Override
    public List<Stock> getAllStocks() {
        try {
            return stockRepository.findAll();
        } catch (Exception e) {
            throw new NoSuchElementException("Stock not found");
        }
    }

    @Override
    public List<Stock> getStockByRangeOfDate(LocalDate startDate, LocalDate endDate) {
        try {
            return stockRepository.findByMarketValuePurchaseDateBetween(startDate, endDate);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Stock not found");
        }
    }

    @Override
    public Stock createStock(Stock stock) {
        try {
            return stockRepository.save(stock);
        } catch (Exception e) {
            e.getCause();
            throw new IllegalArgumentException("Stock not created");
        }
    }

    @Override
    public Stock updateStock(Stock stock) {
        try {
            return stockRepository.save(stock);
        } catch (Exception e) {
            throw new IllegalArgumentException("Stock not updated");
        }
    }

    @Override
    public void deleteStockById(Integer id) {
        try {
            stockRepository.deleteById(id);
        } catch (Exception e) {
            throw new IllegalArgumentException("Stock not deleted");
        }
    }
}
