package com.DIGIPEDIA.Digimon.Collection.mappers;


import com.DIGIPEDIA.Digimon.Collection.dto.digimonTypeAttributeDto.GDigimonTypeAttributeDto;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonTypeDto.GADigimonTypeDto;

import com.DIGIPEDIA.Digimon.Collection.dto.digimonTypeDto.GDigimonTypeDto;
import com.DIGIPEDIA.Digimon.Collection.entities.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "Spring")
public interface DigimonTypeMapper {

    DigimonTypeAttributeMapper DIGIMON_TYPE_ATTRIBUTE_MAPPER = Mappers.getMapper(DigimonTypeAttributeMapper.class);

    default GDigimonTypeAttributeDto digimonTypeAttributeEntityToGDigimonTypeAttributeDto(DigimonTypeAttributeEntity digimonTypeAttribute){
        GDigimonTypeAttributeDto DigimonTypeAttributeDto;
        DigimonTypeAttributeDto = DIGIMON_TYPE_ATTRIBUTE_MAPPER.digimonTypeAttributeEntityToGDigimonTypeAttributeDto(digimonTypeAttribute);
        return DigimonTypeAttributeDto;
    }

    @Mapping(source = "digimonTypeId", target = "digimonTypeIdDto")
    @Mapping(source = "digimonTypeName", target = "digimonTypeNameDto")
    @Mapping(source = "digimonTypeAttribute", target = "digimonTypeAttributeDto")
    GADigimonTypeDto digimonTypeEntityToGADigimonTypeDto(DigimonTypeEntity digimonType);

    @Mapping(source = "digimonTypeId", target = "digimonTypeIdDto")
    @Mapping(source = "digimonTypeName", target = "digimonTypeNameDto")
    GDigimonTypeDto digimonTypeEntityToGDigimonTypeDto(DigimonTypeEntity digimonType);

}
