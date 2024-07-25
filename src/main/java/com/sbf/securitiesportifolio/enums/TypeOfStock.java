package com.sbf.securitiesportifolio.enums;

public enum TypeOfStock {
    PREFERENCIAL(4, "PN", "Ação Preferencial"),
    ORDINARIA(3, "ON", "Ação Ordinária"),
    UNIT(11, "UNIT", "Unit");

    private Integer code;
    private String acronym;
    private String description;

    TypeOfStock(Integer code, String acronym, String description) {
        this.code = code;
        this.acronym = acronym;
        this.description = description;
    }
}
