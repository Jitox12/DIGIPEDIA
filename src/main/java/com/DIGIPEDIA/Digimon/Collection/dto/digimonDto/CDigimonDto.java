package com.DIGIPEDIA.Digimon.Collection.dto.digimonDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CDigimonDto {
    private Integer digimonMemoryDto;
    private String digimonNameDto;
    private byte[] digimonImgDto;
    private String digimonPassiveDto;
    private Integer digimonFamilyIdDto;
    private Integer digimonTypeAttributeIdDto;
    private List<Integer> skillIdDto;
}
