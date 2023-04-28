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
    AttributeMapper INSTANCE = Mappers.getMapper(AttributeMapper.class);

    List<String> digimonTypeTodigimonTypeName(List<DigimonTypeEntity> digimonTypeList);
    String digimonTypeTodigimonTypeName(DigimonTypeEntity digimonType);

    List<String> SkillToSkillName(List<SkillEntity> skillList);
    String SkillToSkillName(SkillEntity skill);

    @Mapping(source = "attributeId", target = "attributeIdDto")
    @Mapping(source = "attributeName", target = "attributeNameDto")
    @Mapping(source = "digimonTypes", target = "digimonTypesNameDto")
    @Mapping(source = "skills", target = "skillsNameDto")
    GAttributeDto AttributeEntityToGAttributeDto(AttributeEntity attribute);


}
