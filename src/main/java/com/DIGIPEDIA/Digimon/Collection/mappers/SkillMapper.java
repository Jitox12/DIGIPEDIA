package com.DIGIPEDIA.Digimon.Collection.mappers;

import com.DIGIPEDIA.Digimon.Collection.dto.attributeDto.GAttributeDto;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonDto.GDigimonDto;
import com.DIGIPEDIA.Digimon.Collection.dto.skillDto.GASkillDto;
import com.DIGIPEDIA.Digimon.Collection.dto.skillDto.GSkillDto;
import com.DIGIPEDIA.Digimon.Collection.dto.skillTypeDto.GSkillTypeDto;
import com.DIGIPEDIA.Digimon.Collection.entities.AttributeEntity;
import com.DIGIPEDIA.Digimon.Collection.entities.DigimonEntity;
import com.DIGIPEDIA.Digimon.Collection.entities.SkillEntity;
import com.DIGIPEDIA.Digimon.Collection.entities.SkillTypeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "Spring")
public interface SkillMapper {
    AttributeMapper ATTRIBUTE_MAPPER = Mappers.getMapper(AttributeMapper.class);
    SkillTypeMapper SKILL_TYPE_MAPPER = Mappers.getMapper(SkillTypeMapper.class);
    DigimonMapper DIGIMON_MAPPER =Mappers.getMapper(DigimonMapper.class);

    default GDigimonDto digimonEntityToGDigimonDto(DigimonEntity digimon){
        GDigimonDto digimonDto;
        digimonDto = DIGIMON_MAPPER.digimontoGDigimonDto(digimon);
        return digimonDto;
    }

    default GAttributeDto attributeEntityToGAttributeDto(AttributeEntity attribute){
        GAttributeDto attributeDto;
        attributeDto = ATTRIBUTE_MAPPER.attributeEntityToGAttributeDto(attribute);
        return attributeDto;
    }

    default GSkillTypeDto skillTypeToGSkillTypeDto(SkillTypeEntity skillType){
        GSkillTypeDto SkillTypeDto;
        SkillTypeDto = SKILL_TYPE_MAPPER.skillTypeEntityToGSkillTypeDto(skillType);
        return SkillTypeDto;
    }

    @Mapping(source = "skillId", target = "skillIdDto")
    @Mapping(source = "skillName", target = "skillNameDto")
    @Mapping(source = "skillDescription", target = "skillDescriptionDto")
    @Mapping(source = "skill_type", target = "skillTypeDto")
    @Mapping(source = "attribute", target = "attributeDto")
    GSkillDto skillEntityToGSkillDto(SkillEntity skill);

    @Mapping(source = "skillId", target = "skillIdDto")
    @Mapping(source = "skillName", target = "skillNameDto")
    @Mapping(source = "skillDescription", target = "skillDescriptionDto")
    @Mapping(source = "skill_type", target = "skillTypeDto")
    @Mapping(source = "attribute", target = "attributeDto")
    @Mapping(source = "digimons", target = "digimonsDto")
    GASkillDto skillEntityToGASkillDto(SkillEntity skill);
}