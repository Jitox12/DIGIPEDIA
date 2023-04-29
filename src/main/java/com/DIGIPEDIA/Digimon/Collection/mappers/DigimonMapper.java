package com.DIGIPEDIA.Digimon.Collection.mappers;

import com.DIGIPEDIA.Digimon.Collection.dto.digimonDto.GADigimonDto;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonFamilyDto.GADigimonFamilyDto;
import com.DIGIPEDIA.Digimon.Collection.entities.DigimonEntity;
import com.DIGIPEDIA.Digimon.Collection.entities.DigimonFamilyEntity;
import com.DIGIPEDIA.Digimon.Collection.entities.SkillEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface DigimonMapper {
    DigimonMapper DIGIMON_MAPPER = Mappers.getMapper(DigimonMapper.class);

    String digimonFamilyMap(DigimonFamilyEntity value);
    List<String> skillMap(List<SkillEntity> value);
    String skillMap(SkillEntity value);
    @Mapping(source = "digimonId", target = "digimonIdDto")
    @Mapping(source = "digimonMemory", target = "digimonMemoryDto")
    @Mapping(source = "digimonName", target = "digimonNameDto")
    @Mapping(source = "digimonImg", target = "digimonImgDto")
    @Mapping(source = "digimonPassive", target = "digimonPassiveDto")
    @Mapping(source = "digimon_family", target = "digimonFamilyDto")
    @Mapping(source = "digimon_type_attribute", target = "digimonTypeAttributeDto")
    @Mapping(source = "skills", target = "skillsDto")
    GADigimonDto digimontoGADigimonDto(DigimonEntity digimon);

}
