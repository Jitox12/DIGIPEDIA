package com.DIGIPEDIA.Digimon.Collection.dao;

import com.DIGIPEDIA.Digimon.Collection.dto.attributeDto.CAttributeDto;
import com.DIGIPEDIA.Digimon.Collection.entities.AttributeEntity;

import java.io.IOException;
import java.util.List;

public interface AttributeDao {
    public void createAttributeDao(CAttributeDto cAttributeDto) throws IOException;
    public List<AttributeEntity> findAllAttribute() throws IOException;
    public AttributeEntity findAttributeByIdDao(Integer attributeId) throws IOException;
    public AttributeEntity findAttributeByNameDao(String attributeName) throws IOException;
}
