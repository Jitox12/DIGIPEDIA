package com.DIGIPEDIA.Digimon.Collection.dto.digimonDto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EvoInvoDigimonDto {
    private GADigimonDto digimonDto;
    private List<GDigimonDto> digimonEvolveListDto;
    private List<GDigimonDto> digimonInvolveListDto;
}