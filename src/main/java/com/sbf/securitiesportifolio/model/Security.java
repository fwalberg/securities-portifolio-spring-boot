package com.sbf.securitiesportifolio.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter(AccessLevel.PROTECTED)
public abstract class Security {
    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200, nullable = false)
    private String companyName;

    @Column(length = 4, nullable = false, unique = true)
    private String tickerSymbol;

    private Boolean isActive;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "marketvalue_id")
    private MarketValue marketValue;

    @PrePersist
    private void prePersist() {
        if (this.isActive == null) {
            this.isActive = true;
        }
    }
}
