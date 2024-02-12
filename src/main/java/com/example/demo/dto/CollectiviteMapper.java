package com.example.demo.dto;

import com.example.demo.entity.Collectivite;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CollectiviteMapper {
    CollectiviteDto collectiviteToDto(Collectivite collectivite);
    Collectivite dtoToCollectivite(CollectiviteDto dto);
}
