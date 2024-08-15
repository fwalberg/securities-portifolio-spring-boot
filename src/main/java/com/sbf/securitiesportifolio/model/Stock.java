package com.sbf.securitiesportifolio.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "STOCKS")
public class Stock extends Security implements Serializable {
    @Column(length = 2, nullable = false)
    private Integer typeOfStock;

    @Column(length = 100)
    private String sectorAndIndustry;

    @Column(length = 9, unique = true)
    private String isinCode;
}
