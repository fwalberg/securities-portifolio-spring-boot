package com.sbf.securitiesportifolio.repository;

import com.sbf.securitiesportifolio.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {
}
