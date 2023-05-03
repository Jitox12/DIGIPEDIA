package com.DIGIPEDIA.Digimon.Collection.mappers;

import com.DIGIPEDIA.Digimon.Collection.dto.skillDto.GSkillDto;
import com.DIGIPEDIA.Digimon.Collection.dto.skillTypeDto.GASkillTypeDto;
import com.DIGIPEDIA.Digimon.Collection.dto.skillTypeDto.GSkillTypeDto;
import com.DIGIPEDIA.Digimon.Collection.entities.SkillEntity;
import com.DIGIPEDIA.Digimon.Collection.entities.SkillTypeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "Spring")
public interface SkillTypeMapper {
    SkillMapper SKILL_MAPPER = Mappers.getMapper(SkillMapper.class);

    default GSkillDto skillEntityToGSkillDto(SkillEntity skill){
        GSkillDto skillDto;
        skillDto = SKILL_MAPPER.skillEntityToGSkillDto(skill);
        return skillDto;
    }
    @Mapping(source = "skillTypeId", target = "skillTypeIdDto")
    @Mapping(source = "skillTypeName", target = "skillTypeNameDto")
    GSkillTypeDto skillTypeEntityToGSkillTypeDto(SkillTypeEntity skillType);
    @Mapping(source = "skillTypeId", target = "skillTypeIdDto")
    @Mapping(source = "skillTypeName", target = "skillTypeNameDto")
    @Mapping(source = "skills", target = "skillsDto")
    GASkillTypeDto skillTypeEntityToGASkillTypeDto(SkillTypeEntity skillType);
}