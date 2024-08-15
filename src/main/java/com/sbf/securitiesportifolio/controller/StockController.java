package com.sbf.securitiesportifolio.controller;

import com.sbf.securitiesportifolio.model.Stock;
import com.sbf.securitiesportifolio.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("stock")
public class StockController {

    private final StockService stockService;

    @GetMapping
    public ResponseEntity<List<Stock>> getAllStocks() {
        return ResponseEntity.ok(stockService.getAllStocks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stock> getStockById(@PathVariable("id") Integer id) {
        Stock stock = stockService.getStockById(id).orElse(null);
        if (stock == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(stock);
    }

    @GetMapping("/company/{name}")
    public ResponseEntity<List<Stock>> getAllStocksByCompany(@PathVariable("name") String name) {
        List<Stock> stocks = stockService.getStockByCompanyName(name);
        if (stocks.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(stocks);
    }

    @GetMapping("/symbol/{symbol}")
    public ResponseEntity<Stock> getStockByTinkerSymbol(@PathVariable("symbol") String symbol) {
        Stock stock = stockService.getStockByTickerSymbol(symbol).orElse(null);
        if (stock == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(stock);
    }

    @PostMapping()
    public ResponseEntity<Stock> createStock(@RequestBody Stock stock) {
        System.out.println(stock.getCompanyName());
        Stock stockCreated = stockService.createStock(stock);

        return ResponseEntity.ok().body(stockCreated);
    }

    @PutMapping()
    public ResponseEntity<Stock> updateStock(@RequestBody Stock stock) {
        Stock stockUpdated = stockService.updateStock(stock);
        return ResponseEntity.ok().body(stockUpdated);
    }

    @DeleteMapping("/{id}")
    public void deleteStock(@PathVariable("id") Integer id) {
        stockService.deleteStockById(id);
    }
}
