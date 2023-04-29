package com.DIGIPEDIA.Digimon.Collection.services;

import com.DIGIPEDIA.Digimon.Collection.dto.digimonFamilyDto.CDigimonFamilyDto;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonFamilyDto.GADigimonFamilyDto;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonFamilyDto.GDigimonFamilyDto;

import java.util.List;

public interface DigimonFamilyService {

    public void createDigimonFamily(CDigimonFamilyDto cDigimonFamilyDto);

    public GADigimonFamilyDto findDigimonFamilyById(Integer digimonFamilyId);
    public GADigimonFamilyDto findDigimonFamilyByName(String digimonFamilyName);
    public List<GDigimonFamilyDto> findAllDigimonFamily();
}
