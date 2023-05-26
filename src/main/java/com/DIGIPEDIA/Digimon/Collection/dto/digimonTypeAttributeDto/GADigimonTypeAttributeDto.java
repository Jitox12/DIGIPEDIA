package com.DIGIPEDIA.Digimon.Collection.dto.digimonTypeAttributeDto;

import com.DIGIPEDIA.Digimon.Collection.dto.digimonDto.GDigimonDto;
import lombok.*;

import javax.persistence.Lob;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GADigimonTypeAttributeDto {
    private String digimonTypeAttributeIdDto;
    private String digimonTypeAttributeNameDto;
    @Lob
    private byte[] digimonTypeAttributeImgDto;
    private List<GDigimonDto> digimonsDto;
}
