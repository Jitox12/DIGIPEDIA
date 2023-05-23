package com.DIGIPEDIA.Digimon.Collection.dao;

import com.DIGIPEDIA.Digimon.Collection.dto.digimonDto.CDigimonDto;
import com.DIGIPEDIA.Digimon.Collection.entities.DigimonEntity;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface DigimonDao {

    public void createDigimonDao(CDigimonDto cDigimonDto) throws IOException;
    public List<DigimonEntity> findAllDigimonDao() throws IOException;
    public DigimonEntity findDigimonByIdDao(Integer digimonId) throws IOException;
    public DigimonEntity findDigimonByNameDao(String digimonName) throws IOException;
}
