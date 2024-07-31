package com.sbf.securitiesportifolio.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.AccessType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "MARKET_VALUE")
public class MarketValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, precision = 10)
    private Integer quantity;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal entryPrice;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal currentPrice;

    @Column(nullable = false, updatable = false)
    private LocalDateTime purchaseDate;

    @Column(updatable = false)
    private LocalDateTime saleDate;

    private LocalDateTime lastUpdate;
}
