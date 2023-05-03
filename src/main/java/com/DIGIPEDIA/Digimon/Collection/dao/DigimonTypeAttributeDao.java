package com.DIGIPEDIA.Digimon.Collection.dao;

import com.DIGIPEDIA.Digimon.Collection.dto.digimonTypeAttributeDto.CDigimonTypeAttributeDto;
import com.DIGIPEDIA.Digimon.Collection.entities.DigimonTypeAttributeEntity;

import java.io.IOException;
import java.util.List;

public interface DigimonTypeAttributeDao {

    public void createSkillDao(CDigimonTypeAttributeDto digimonTypeAttribute) throws IOException;
    public List<DigimonTypeAttributeEntity> findAllDigimonTypeAttributeDao() throws IOException;
    public DigimonTypeAttributeEntity findDigimonTypeAttributeByIdDao(Integer digimonTypeAttributeId) throws IOException;
    public DigimonTypeAttributeEntity findDigimonTypeAttributeByNameDao(String digimonTypeAttributeName) throws IOException;
}
