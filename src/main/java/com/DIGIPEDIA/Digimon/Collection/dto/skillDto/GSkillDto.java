package com.DIGIPEDIA.Digimon.Collection.dto.skillDto;

import com.DIGIPEDIA.Digimon.Collection.dto.attributeDto.GAttributeDto;
import com.DIGIPEDIA.Digimon.Collection.dto.skillTypeDto.GSkillTypeDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GSkillDto {
    private Integer skillIdDto;
    private String skillNameDto;
    private String skillDescriptionDto;
    private GSkillTypeDto skillTypeDto;
    private GAttributeDto attributeDto;
}
