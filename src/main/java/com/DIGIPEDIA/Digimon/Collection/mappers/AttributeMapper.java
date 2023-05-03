package com.DIGIPEDIA.Digimon.Collection.mappers;

import com.DIGIPEDIA.Digimon.Collection.dto.attributeDto.GAAttributeDto;
import com.DIGIPEDIA.Digimon.Collection.dto.attributeDto.GAttributeDto;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonTypeAttributeDto.GDigimonTypeAttributeDto;
import com.DIGIPEDIA.Digimon.Collection.dto.skillDto.GSkillDto;
import com.DIGIPEDIA.Digimon.Collection.entities.AttributeEntity;
import com.DIGIPEDIA.Digimon.Collection.entities.DigimonTypeAttributeEntity;
import com.DIGIPEDIA.Digimon.Collection.entities.SkillEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "Spring")
public interface AttributeMapper {
    SkillMapper SKILL_MAPPER = Mappers.getMapper(SkillMapper.class);
    DigimonTypeAttributeMapper DIGIMON_TYPE_ATTRIBUTE_MAPPER = Mappers.getMapper(DigimonTypeAttributeMapper.class);


    default GSkillDto skillEntityToGSkillDto(SkillEntity skill){
        GSkillDto skillDto;
        skillDto = SKILL_MAPPER.skillEntityToGSkillDto(skill);
        return skillDto;
    }

    default GDigimonTypeAttributeDto skillEntityToGSkillDto(DigimonTypeAttributeEntity digimonTypeAttribute){
        GDigimonTypeAttributeDto digimonTypeAttributeDto;
        digimonTypeAttributeDto =
                DIGIMON_TYPE_ATTRIBUTE_MAPPER.digimonTypeAttributeEntityToGDigimonTypeAttributeDto(digimonTypeAttribute);
        return digimonTypeAttributeDto;
    }

    @Mapping(source = "attributeId", target = "attributeIdDto")
    @Mapping(source = "attributeName", target = "attributeNameDto")
    @Mapping(source = "attributeImg", target = "attributeImgDto")
    GAttributeDto attributeEntityToGAttributeDto(AttributeEntity attribute);

    @Mapping(source = "attributeId", target = "attributeIdDto")
    @Mapping(source = "attributeName", target = "attributeNameDto")
    @Mapping(source = "attributeImg", target = "attributeImgDto")
    @Mapping(source = "digimonTypesAttribute", target = "digimonTypesAttributeDto")
    @Mapping(source = "skills", target = "skillsDto")
    GAAttributeDto attributeEntityToGAAttributeDto(AttributeEntity attribute);
}