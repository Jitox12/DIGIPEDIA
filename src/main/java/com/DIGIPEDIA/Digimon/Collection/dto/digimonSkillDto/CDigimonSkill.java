package com.DIGIPEDIA.Digimon.Collection.dto.digimonSkillDto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CDigimonSkill {
    private Integer digimonIdDto;
    private List<Integer> skillIdListDto;
}
