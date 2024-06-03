package com.payfip.payfip.dto;

import com.payfip.payfip.models.Collectivite;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CollectiviteMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nomCollectivite", source = "nomCollectivite")
    @Mapping(target = "codeCollectivite", source = "codeCollectivite")
    CollectiviteDto collectiviteToCollectiviteDto(Collectivite collectivite);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nomCollectivite", source = "nomCollectivite")
    @Mapping(target = "codeCollectivite", source = "codeCollectivite")
    Collectivite collectiviteDtoToCollectivite(CollectiviteDto collectiviteDto);
}
