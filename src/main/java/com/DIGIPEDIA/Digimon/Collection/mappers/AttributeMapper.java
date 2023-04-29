package com.DIGIPEDIA.Digimon.Collection.mappers;

import com.DIGIPEDIA.Digimon.Collection.dto.attributeDto.GAttributeDto;
import com.DIGIPEDIA.Digimon.Collection.entities.AttributeEntity;
import com.DIGIPEDIA.Digimon.Collection.entities.DigimonTypeEntity;
import com.DIGIPEDIA.Digimon.Collection.entities.SkillEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface AttributeMapper {
    AttributeMapper ATTRIBUTE_MAPPER = Mappers.getMapper(AttributeMapper.class);

    List<String> digimonTypeToDigimonTypeName(List<DigimonTypeEntity> digimonTypeList);
    String digimonTypeToDigimonTypeName(DigimonTypeEntity digimonType);

    List<String> SkillToSkillName(List<SkillEntity> skillList);
    String SkillToSkillName(SkillEntity skill);

    @Mapping(source = "attributeId", target = "attributeIdDto")
    @Mapping(source = "attributeName", target = "attributeNameDto")
    @Mapping(source = "skills", target = "skillsNameDto")
    GAttributeDto attributeEntityToGAttributeDto(AttributeEntity attribute);
}
