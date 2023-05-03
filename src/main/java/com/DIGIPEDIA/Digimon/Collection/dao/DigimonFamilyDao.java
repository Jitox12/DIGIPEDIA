package com.DIGIPEDIA.Digimon.Collection.dao;

import com.DIGIPEDIA.Digimon.Collection.dto.digimonFamilyDto.CDigimonFamilyDto;
import com.DIGIPEDIA.Digimon.Collection.entities.DigimonFamilyEntity;

import java.io.IOException;
import java.util.List;

public interface DigimonFamilyDao {

    public void createDigimonFamilyDao(CDigimonFamilyDto cDigimonFamilyDto) throws IOException;
    public List<DigimonFamilyEntity> findAllDigimonFamilyDao() throws IOException;
    public DigimonFamilyEntity findDigimonFamilyByIdDao(Integer digimonFamilyId) throws IOException;
    public DigimonFamilyEntity findDigimonFamilyByNameDao(String digimonFamilyName) throws IOException;
}
