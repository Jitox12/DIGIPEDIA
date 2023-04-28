package com.DIGIPEDIA.Digimon.Collection.dao;

import com.DIGIPEDIA.Digimon.Collection.dto.attributeDto.CAttributeDto;
import com.DIGIPEDIA.Digimon.Collection.entities.AttributeEntity;

import java.util.List;

public interface AttributeDao {
    public void createAttributeDao(CAttributeDto cAttributeDto);
    public List<AttributeEntity> findAllAttribute();
    public AttributeEntity findAttributeByIdDao(Integer attributeId);
    public AttributeEntity findAttributeByNameDao(String attributeName);
}
