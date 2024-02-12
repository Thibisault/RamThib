package com.example.demo.dto;

import com.example.demo.entity.Facture;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FactureMapper {
    FactureDto factureToDto(Facture facture);
    Facture dtoToFacture(FactureDto dto);
}
