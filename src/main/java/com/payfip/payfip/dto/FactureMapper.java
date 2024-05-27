//path: src/main/java/com/payfip/payfip/dto/FactureMapper.java
package com.payfip.payfip.dto;

import com.payfip.payfip.models.Facture;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FactureMapper {

    FactureMapper INSTANCE = Mappers.getMapper(FactureMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "typeFacture", source = "typeFacture")
    @Mapping(target = "montantFacture", source = "montantFacture")
    @Mapping(target = "referenceFacture", source = "referenceFacture")
    FactureDto factureToFactureDto(Facture facture);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "typeFacture", source = "typeFacture")
    @Mapping(target = "montantFacture", source = "montantFacture")
    @Mapping(target = "referenceFacture", source = "referenceFacture")
    Facture factureDtoToFacture(FactureDto factureDto);

    List<FactureDto> facturesToFactureDtos(List<Facture> factures);

    List<Facture> factureDtosToFactures(List<FactureDto> factureDtos);
}
