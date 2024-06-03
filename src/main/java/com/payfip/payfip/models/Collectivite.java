package com.payfip.payfip.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Collectivite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomCollectivite;
    private String codeCollectivite;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomCollectivite() {
        return nomCollectivite;
    }

    public void setNomCollectivite(String nomCollectivite) {
        this.nomCollectivite = nomCollectivite;
    }

    public String getCodeCollectivite() {
        return codeCollectivite;
    }

    public void setCodeCollectivite(String codeCollectivite) {
        this.codeCollectivite = codeCollectivite;
    }
}
