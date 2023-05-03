package com.DIGIPEDIA.Digimon.Collection.dto.digimonFamilyDto;

import com.DIGIPEDIA.Digimon.Collection.dto.digimonDto.GDigimonDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GADigimonFamilyDto {
    private Integer digimonFamilyIdDto;
    private String digimonFamilyNameDto;
    private List<GDigimonDto> digimonsDto;
}
