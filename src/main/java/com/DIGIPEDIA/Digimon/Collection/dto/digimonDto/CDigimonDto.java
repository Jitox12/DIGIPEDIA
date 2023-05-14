package com.DIGIPEDIA.Digimon.Collection.dto.digimonDto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
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
