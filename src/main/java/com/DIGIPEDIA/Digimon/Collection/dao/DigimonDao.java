package com.DIGIPEDIA.Digimon.Collection.dao;

import com.DIGIPEDIA.Digimon.Collection.dto.digimonDto.CDigimonDto;
import com.DIGIPEDIA.Digimon.Collection.entities.DigimonEntity;
import org.springframework.data.jpa.repository.Query;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface DigimonDao {

    void createDigimonDao(CDigimonDto cDigimonDto) throws IOException;
    List<DigimonEntity> findAllDigimonDao() throws IOException;
    DigimonEntity findDigimonByIdDao(Integer digimonId) throws IOException;
    DigimonEntity findDigimonByNameDao(String digimonName) throws IOException;
    List<DigimonEntity> findEvolveDigimonList(Integer digimonId) throws IOException;
    List<DigimonEntity> findInvolveDigimonList(Integer digimonId) throws IOException;
}
