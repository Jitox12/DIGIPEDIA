package com.DIGIPEDIA.Digimon.Collection.mappers;

import com.DIGIPEDIA.Digimon.Collection.dto.digimonTypeAttributeDto.GADigimonTypeAttributeDto;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonTypeAttributeDto.GDigimonTypeAttributeDto;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonDto.GDigimonDto;
import com.DIGIPEDIA.Digimon.Collection.entities.DigimonEntity;
import com.DIGIPEDIA.Digimon.Collection.entities.DigimonTypeAttributeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "Spring")
public interface DigimonTypeAttributeMapper {

    DigimonTypeAttributeMapper DIGIMON_TYPE_ATTRIBUTE_MAPPER = Mappers.getMapper(DigimonTypeAttributeMapper.class);

    DigimonMapper DIGIMON_MAPPER =Mappers.getMapper(DigimonMapper.class);

    default GDigimonDto digimonEntityToGDigimonDto(DigimonEntity digimon){
        GDigimonDto digimonDto;
        digimonDto = DIGIMON_MAPPER.digimontoGDigimonDto(digimon);
        return digimonDto;
    }

    @Mapping(source = "digimonTypeAttributeId", target = "digimonTypeAttributeIdDto")
    @Mapping(source = "digimonTypeAttributeName", target = "digimonTypeAttributeNameDto")
    @Mapping(source = "digimonTypeAttributeImg", target = "digimonTypeAttributeImgDto")
    GDigimonTypeAttributeDto digimonTypeAttributeEntityToGDigimonTypeAttributeDto(DigimonTypeAttributeEntity digimonTypeAttribute);

    @Mapping(source = "digimonTypeAttributeId", target = "digimonTypeAttributeIdDto")
    @Mapping(source = "digimonTypeAttributeName", target = "digimonTypeAttributeNameDto")
    @Mapping(source = "digimonTypeAttributeImg", target = "digimonTypeAttributeImgDto")
    @Mapping(source = "digimons", target = "digimonsDto")
    GADigimonTypeAttributeDto digimonTypeAttributeEntityToGADigimonTypeAttributeDto(DigimonTypeAttributeEntity digimonTypeAttribute);
}