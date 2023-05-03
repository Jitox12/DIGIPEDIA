package com.DIGIPEDIA.Digimon.Collection.mappers;

import com.DIGIPEDIA.Digimon.Collection.dto.digimonTypeAttributeDto.GDigimonTypeAttributeDto;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonDto.GADigimonDto;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonDto.GDigimonDto;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonFamilyDto.GDigimonFamilyDto;
import com.DIGIPEDIA.Digimon.Collection.dto.skillDto.GSkillDto;
import com.DIGIPEDIA.Digimon.Collection.entities.DigimonEntity;
import com.DIGIPEDIA.Digimon.Collection.entities.DigimonFamilyEntity;
import com.DIGIPEDIA.Digimon.Collection.entities.DigimonTypeAttributeEntity;
import com.DIGIPEDIA.Digimon.Collection.entities.SkillEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "Spring")
public interface DigimonMapper {
SkillMapper SKILL_MAPPER = Mappers.getMapper(SkillMapper.class);
DigimonFamilyMapper DIGIMON_FAMILY_MAPPER = Mappers.getMapper(DigimonFamilyMapper.class);
DigimonTypeAttributeMapper DIGIMON_TYPE_ATTRIBUTE_MAPPER = Mappers.getMapper(DigimonTypeAttributeMapper.class);

    default GSkillDto skillEntityToGSkillDto(SkillEntity skill){
        GSkillDto skillDto;
        skillDto = SKILL_MAPPER.skillEntityToGSkillDto(skill);
        return skillDto;
    }

    default GDigimonFamilyDto digimonFamilyToGDigimonFamilyDto(DigimonFamilyEntity digimonFamily){
        GDigimonFamilyDto digimonFamilyDto;
        digimonFamilyDto = DIGIMON_FAMILY_MAPPER.digimonTypetoGDigimonTypeDto(digimonFamily);
        return digimonFamilyDto;
    }

    default GDigimonTypeAttributeDto digimonTypeAttributeEntityToGDigimonTypeAttributeDto(DigimonTypeAttributeEntity digimonTypeAttribute){
        GDigimonTypeAttributeDto DigimonTypeAttributeDto;
        DigimonTypeAttributeDto = DIGIMON_TYPE_ATTRIBUTE_MAPPER.digimonTypeAttributeEntityToGDigimonTypeAttributeDto(digimonTypeAttribute);
        return DigimonTypeAttributeDto;
    }

    @Mapping(source = "digimonId", target = "digimonIdDto")
    @Mapping(source = "digimonMemory", target = "digimonMemoryDto")
    @Mapping(source = "digimonName", target = "digimonNameDto")
    @Mapping(source = "digimonImg", target = "digimonImgDto")
    @Mapping(source = "digimonPassive", target = "digimonPassiveDto")
    @Mapping(source = "digimon_family", target = "digimonFamilyDto")
    @Mapping(source = "digimon_type_attribute", target = "digimonTypeAttributeDto")
    @Mapping(source = "skills", target = "skillsDto")
    GADigimonDto digimontoGADigimonDto(DigimonEntity digimon);

    @Mapping(source = "digimonId", target = "digimonIdDto")
    @Mapping(source = "digimonMemory", target = "digimonMemoryDto")
    @Mapping(source = "digimonName", target = "digimonNameDto")
    @Mapping(source = "digimonImg", target = "digimonImgDto")
    @Mapping(source = "digimonPassive", target = "digimonPassiveDto")
    @Mapping(source = "digimon_family", target = "digimonFamilyDto")
    @Mapping(source = "digimon_type_attribute", target = "digimonTypeAttributeDto")
    GDigimonDto digimontoGDigimonDto(DigimonEntity digimon);
}