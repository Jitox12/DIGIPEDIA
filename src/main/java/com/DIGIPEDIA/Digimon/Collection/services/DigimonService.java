package com.DIGIPEDIA.Digimon.Collection.services;

import com.DIGIPEDIA.Digimon.Collection.dto.digimonDto.CDigimonDto;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonDto.GADigimonDto;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonDto.GDigimonDto;


import java.util.List;

public interface DigimonService {

    public void createDigimon(CDigimonDto cDigimonDto);
    public GADigimonDto findDigimonById(Integer digimonId);
    public GADigimonDto findDigimonByName(String digimonName);
    public List<GDigimonDto> findAllDigimon();
}
