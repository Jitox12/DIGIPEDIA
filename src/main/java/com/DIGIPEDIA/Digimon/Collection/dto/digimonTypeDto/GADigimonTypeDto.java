package com.DIGIPEDIA.Digimon.Collection.dto.digimonTypeDto;

import com.DIGIPEDIA.Digimon.Collection.dto.digimonTypeAttributeDto.GDigimonTypeAttributeDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GADigimonTypeDto {

    private Integer digimonTypeIdDto;
    private String digimonTypeNameDto;
    private List<GDigimonTypeAttributeDto> digimonTypeAttributeDto;
}
