package com.DIGIPEDIA.Digimon.Collection.mappers;

import com.DIGIPEDIA.Digimon.Collection.dto.digimonDto.GADigimonDto;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonFamilyDto.GADigimonFamilyDto;
import com.DIGIPEDIA.Digimon.Collection.entities.DigimonEntity;
import com.DIGIPEDIA.Digimon.Collection.entities.DigimonFamilyEntity;
import com.DIGIPEDIA.Digimon.Collection.entities.DigimonTypeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "Spring", uses = DigimonMapper.class)
public interface DigimonFamilyMapper {
    DigimonFamilyMapper DIGIMON_FAMILY_MAPPER = Mappers.getMapper(DigimonFamilyMapper.class);


    @Mapping(source = "digimonFamilyId", target = "digimonFamilyIdDto")
    @Mapping(source = "digimonFamilyName", target = "digimonFamilyNameDto")
    @Mapping(source = "digimons", target = "digimonsDto")
    GADigimonFamilyDto digimonTypetoGADigimonTypeDto(DigimonFamilyEntity digimonFamily);
}
