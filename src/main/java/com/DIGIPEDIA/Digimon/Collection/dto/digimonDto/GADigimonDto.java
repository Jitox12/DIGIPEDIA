package com.DIGIPEDIA.Digimon.Collection.dto.digimonDto;

import com.DIGIPEDIA.Digimon.Collection.dto.digimonTypeAttributeDto.GDigimonTypeAttributeDto;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonFamilyDto.GDigimonFamilyDto;
import com.DIGIPEDIA.Digimon.Collection.dto.skillDto.GSkillDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Lob;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GADigimonDto {

    private Integer digimonIdDto;
    private Integer digimonMemoryDto;
    private String digimonNameDto;
    @Lob
    private byte[] digimonImgDto;
    private String digimonPassiveDto;
    private GDigimonFamilyDto digimonFamilyDto;
    private GDigimonTypeAttributeDto digimonTypeAttributeDto;
    private List<GSkillDto> skillsDto;
}