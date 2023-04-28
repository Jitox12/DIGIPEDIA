package com.DIGIPEDIA.Digimon.Collection.services.servicesImpl;

import com.DIGIPEDIA.Digimon.Collection.dao.daoImpl.AttributeDaoImpl;
import com.DIGIPEDIA.Digimon.Collection.dto.attributeDto.CAttributeDto;
import com.DIGIPEDIA.Digimon.Collection.dto.attributeDto.GAttributeDto;
import com.DIGIPEDIA.Digimon.Collection.entities.AttributeEntity;
import com.DIGIPEDIA.Digimon.Collection.mappers.AttributeMapper;
import com.DIGIPEDIA.Digimon.Collection.services.AttributeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttributeServiceImpl implements AttributeService {

    private final AttributeDaoImpl attributeDao;
    private final AttributeMapper attributeMapper;

    public AttributeServiceImpl(AttributeDaoImpl attributeDao, AttributeMapper attributeMapper) {
        this.attributeDao = attributeDao;
        this.attributeMapper = attributeMapper;
    }

    @Override
    public void createAttribute(CAttributeDto cAttributeDto) {
        attributeDao.createAttributeDao(cAttributeDto);
    }

    @Override
    public GAttributeDto findAttributeById(Integer attributeId) {
        AttributeEntity attribute;
        GAttributeDto attributeDto;

        attribute = attributeDao.findAttributeByIdDao(attributeId);
        attributeDto = attributeMapper.AttributeEntityToGAttributeDto(attribute);

        return attributeDto;
    }

    @Override
    public GAttributeDto findAttributeByName(String attributeName) {
        AttributeEntity attribute;
        GAttributeDto attributeDto;

        attribute = attributeDao.findAttributeByNameDao(attributeName);
        attributeDto = attributeMapper.AttributeEntityToGAttributeDto(attribute);

        return attributeDto;
    }

    @Override
    public List<GAttributeDto> findAllAttribute() {
        List<AttributeEntity> attributeList;
        List<GAttributeDto> attributeDtoList;

        attributeList = attributeDao.findAllAttribute();

        attributeDtoList = attributeList.stream().map(attributeMapper::AttributeEntityToGAttributeDto).collect(Collectors.toList());

        return attributeDtoList;
    }
}
