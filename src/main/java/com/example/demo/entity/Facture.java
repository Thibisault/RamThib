package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Data
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private BigDecimal montant;
    private long reference;

    private Timestamp dateCreation;
    private Timestamp dateReglement;

    private Boolean payerOuNon;
}