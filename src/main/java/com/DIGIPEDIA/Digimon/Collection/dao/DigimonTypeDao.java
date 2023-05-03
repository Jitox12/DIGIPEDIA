package com.DIGIPEDIA.Digimon.Collection.dao;

import com.DIGIPEDIA.Digimon.Collection.dto.digimonTypeDto.CDigimonTypeDto;
import com.DIGIPEDIA.Digimon.Collection.entities.DigimonTypeEntity;

import java.io.IOException;
import java.util.List;

public interface DigimonTypeDao {

    public void createDigimonTypeDao(CDigimonTypeDto digimonTypeDto) throws IOException;
    public List<DigimonTypeEntity> findAllDigimonTypeDao() throws IOException;
    public DigimonTypeEntity findDigimonTypeByIdDao(Integer digimonTypeId) throws IOException;
    public DigimonTypeEntity findDigimonTypeByNameDao(String digimonTypeName) throws IOException;
}
