package com.DIGIPEDIA.Digimon.Collection.dto.skillDto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CSkillDto {
    private String skillNameDto;
    private String skillDescriptionDto;
    private Integer skillTypeIdDto;
    private Integer attributeIdDto;

}
