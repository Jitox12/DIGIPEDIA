package com.DIGIPEDIA.Digimon.Collection.dto.skillDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CSkillDto {
    private String skillNameDto;
    private String skillDescriptionDto;
    private Integer skillTypeIdDto;
    private Integer attributeIdDto;

}
