//path: src/main/java/com/payfip/payfip/dto/FactureDto.java
package com.payfip.payfip.dto;

import lombok.Data;

@Data
public class FactureDto {
    private Long id;
    private String typeFacture;
    private Double montantFacture;
    private String referenceFacture;

    //getter and setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeFacture() {
        return typeFacture;
    }

    public void setTypeFacture(String typeFacture) {
        this.typeFacture = typeFacture;
    }

    public Double getMontantFacture() {
        return montantFacture;
    }

    public void setMontantFacture(Double montantFacture) {
        this.montantFacture = montantFacture;
    }

    public String getReferenceFacture() {
        return referenceFacture;
    }

    public void setReferenceFacture(String referenceFacture) {
        this.referenceFacture = referenceFacture;
    }
}
