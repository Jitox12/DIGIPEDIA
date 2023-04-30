package com.DIGIPEDIA.Digimon.Collection.dto.skillTypeDto;

import com.DIGIPEDIA.Digimon.Collection.dto.skillDto.GSkillDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GASkillTypeDto {
    private Integer skillTypeIdDto;
    private String skillTypeName;
    private List<GSkillDto> skillsDto;
}
