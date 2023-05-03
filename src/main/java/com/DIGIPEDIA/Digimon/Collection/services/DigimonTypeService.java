package com.DIGIPEDIA.Digimon.Collection.services;

import com.DIGIPEDIA.Digimon.Collection.dto.digimonTypeDto.CDigimonTypeDto;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonTypeDto.GADigimonTypeDto;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonTypeDto.GDigimonTypeDto;

import java.util.List;

public interface DigimonTypeService {

    public void createDigimonType(CDigimonTypeDto digimonTypeDto);
    public GADigimonTypeDto findDigimonTypeById(Integer digimonTypeId);
    public GADigimonTypeDto findDigimonTypeByName(String digimonTypeName);
    public List<GDigimonTypeDto> findAllDigimonTypes();
}
