package com.payfip.payfip.dto;

import lombok.Data;

@Data
public class CollectiviteDto {
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
