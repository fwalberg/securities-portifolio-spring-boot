package com.sbf.securitiesportifolio.repository;

import com.sbf.securitiesportifolio.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {
    List<Stock> findByCompanyName(String companyName);
    Optional<Stock> findByTickerSymbol(String tinkerSymbol);
    List<Stock> findByMarketValuePurchaseDateBetween(LocalDate startDate, LocalDate endDate);
}
