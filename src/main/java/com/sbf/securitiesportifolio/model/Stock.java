package com.sbf.securitiesportifolio.model;

import com.sbf.securitiesportifolio.service.SecurityStrategy;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "STOCK")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200, nullable = false)
    private String companyName;

    @Column(length = 6, nullable = false, unique = true)
    private String tickerSymbol;

    @Column(length = 1, nullable = false)
    private Integer typeOfStock;

    @Column(length = 100, nullable = false)
    private String sectorAndIndustry;

    @Column(length = 9, unique = true)
    private String isinCode;

    @OneToOne(mappedBy = "stock", cascade = CascadeType.ALL, orphanRemoval = true)
    private MarketValue marketValue;

}
