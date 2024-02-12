package com.example.demo.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class FactureDto {

    private BigDecimal montant;
    private long reference;

    private Timestamp dateCreation;

    private Timestamp dateReglement;

    private Boolean payerOuNon;

}
