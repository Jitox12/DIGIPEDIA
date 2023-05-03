package com.DIGIPEDIA.Digimon.Collection.mappers;

import com.DIGIPEDIA.Digimon.Collection.dto.digimonDto.GDigimonDto;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonFamilyDto.GADigimonFamilyDto;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonFamilyDto.GDigimonFamilyDto;
import com.DIGIPEDIA.Digimon.Collection.entities.DigimonEntity;
import com.DIGIPEDIA.Digimon.Collection.entities.DigimonFamilyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "Spring")
public interface DigimonFamilyMapper {
    DigimonMapper DIGIMON_MAPPER =Mappers.getMapper(DigimonMapper.class);

    default GDigimonDto digimonEntityToGDigimonDto(DigimonEntity digimon){
        GDigimonDto digimonDto;
        digimonDto = DIGIMON_MAPPER.digimontoGDigimonDto(digimon);
        return digimonDto;
    }

    @Mapping(source = "digimonFamilyId", target = "digimonFamilyIdDto")
    @Mapping(source = "digimonFamilyName", target = "digimonFamilyNameDto")
    GDigimonFamilyDto digimonTypetoGDigimonTypeDto(DigimonFamilyEntity digimonFamily);

    @Mapping(source = "digimonFamilyId", target = "digimonFamilyIdDto")
    @Mapping(source = "digimonFamilyName", target = "digimonFamilyNameDto")
    @Mapping(source = "digimons", target = "digimonsDto")
    GADigimonFamilyDto digimonTypetoGADigimonTypeDto(DigimonFamilyEntity digimonFamily);
}
