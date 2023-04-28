package com.DIGIPEDIA.Digimon.Collection.services;

import com.DIGIPEDIA.Digimon.Collection.dto.attributeDto.CAttributeDto;
import com.DIGIPEDIA.Digimon.Collection.dto.attributeDto.GAttributeDto;

import java.util.List;

public interface AttributeService {
    public void createAttribute(CAttributeDto cAttributeDto);

    public GAttributeDto findAttributeById(Integer attributeId);
    public GAttributeDto findAttributeByName(String attributeName);
    public List<GAttributeDto> findAllAttribute();
}
