package com.DIGIPEDIA.Digimon.Collection.TestData.Dto;

import com.DIGIPEDIA.Digimon.Collection.TestData.TestData;
import com.DIGIPEDIA.Digimon.Collection.dto.attributeDto.CAttributeDto;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonDto.CDigimonDto;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonFamilyDto.CDigimonFamilyDto;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonSkillDto.CDigimonSkill;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonTypeAttributeDto.CDigimonTypeAttributeDto;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonTypeDto.CDigimonTypeDto;
import com.DIGIPEDIA.Digimon.Collection.dto.skillDto.CSkillDto;
import com.DIGIPEDIA.Digimon.Collection.dto.skillTypeDto.CSkillTypeDto;

public class CDtoTestData extends TestData {

    //Create Dtos

    public static CAttributeDto createAttributeDto() {
        return CAttributeDto.builder()
                .attributeNameDto(attributeName)
                .attributeImgDto(imgData)
                .build();
    }

    public static CDigimonDto createDigimonDto() {
        idList.add(1);

        return CDigimonDto
                .builder()
                .digimonMemoryDto(5)
                .digimonNameDto(digimonName)
                .digimonImgDto(imgData)
                .digimonPassiveDto(digimonPassive)
                .digimonFamilyIdDto(1)
                .digimonTypeAttributeIdDto(1)
                .skillIdDto(idList)
                .build();
    }

    public static CDigimonFamilyDto createDigimonFamilyDto() {
        return CDigimonFamilyDto
                .builder()
                .digimonFamilyNameDto(digimonFamilyName)
                .build();
    }

    public static CDigimonSkill createDigimonSkillDto() {
        return CDigimonSkill.builder()
                .digimonIdDto(1)
                .skillIdListDto(idList)
                .build();
    }

    public static CDigimonTypeAttributeDto createDigimonTypeAttributeDto() {
        return CDigimonTypeAttributeDto
                .builder()
                .digimonTypeIdDto(1)
                .attributeIdDto(1)
                .digimonTypeAttributeImgDto(imgData)
                .digimonTypeAttributeNameDto(digimonTypeName)
                .build();
    }

    public static CDigimonTypeDto createDigimonTypeDto() {
        return CDigimonTypeDto
                .builder()
                .digimonTypeNameDto(digimonTypeName)
                .build();
    }

    public static CSkillDto createSkillDto() {
        return CSkillDto
                .builder()
                .skillNameDto(skillName)
                .skillDescriptionDto(skillDescription)
                .skillTypeIdDto(1)
                .attributeIdDto(1)
                .build();
    }

    public static CSkillTypeDto createSkillTypeDto() {
        return CSkillTypeDto
                .builder()
                .skillTypeNameDto(skillTypeName)
                .build();
    }

}
