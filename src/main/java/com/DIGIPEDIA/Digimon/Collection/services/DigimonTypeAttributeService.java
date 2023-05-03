package com.DIGIPEDIA.Digimon.Collection.services;

import com.DIGIPEDIA.Digimon.Collection.dto.digimonTypeAttributeDto.CDigimonTypeAttributeDto;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonTypeAttributeDto.GADigimonTypeAttributeDto;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonTypeAttributeDto.GDigimonTypeAttributeDto;


import java.util.List;

public interface DigimonTypeAttributeService {

    public void createDigimonTypeAttribute(CDigimonTypeAttributeDto digimonTypeAttributeDto);
    public GADigimonTypeAttributeDto findDigimonTypeAttributeById(Integer digimonTypeAttributeId);
    public GADigimonTypeAttributeDto findDigimonTypeAttributeByName(String digimonTypeAttributeName);
    public List<GDigimonTypeAttributeDto> findAllDigimonTypeAttribute();
}
