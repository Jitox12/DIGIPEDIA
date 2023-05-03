package com.DIGIPEDIA.Digimon.Collection.services.servicesImpl;

import com.DIGIPEDIA.Digimon.Collection.dao.AttributeDao;
import com.DIGIPEDIA.Digimon.Collection.dto.attributeDto.CAttributeDto;
import com.DIGIPEDIA.Digimon.Collection.dto.attributeDto.GAAttributeDto;
import com.DIGIPEDIA.Digimon.Collection.dto.attributeDto.GAttributeDto;
import com.DIGIPEDIA.Digimon.Collection.entities.AttributeEntity;
import com.DIGIPEDIA.Digimon.Collection.mappers.AttributeMapper;
import com.DIGIPEDIA.Digimon.Collection.services.AttributeService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttributeServiceImpl implements AttributeService {

    private final AttributeDao attributeDao;
    private final AttributeMapper attributeMapper;

    public AttributeServiceImpl(AttributeDao attributeDao, AttributeMapper attributeMapper) {
        this.attributeDao = attributeDao;
        this.attributeMapper = attributeMapper;
    }

    @Override
    public void createAttribute(CAttributeDto cAttributeDto) {
        try {
            attributeDao.createAttributeDao(cAttributeDto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public GAAttributeDto findAttributeById(Integer attributeId) {
        try {
            AttributeEntity attribute;
            GAAttributeDto attributeDto;
            attribute = attributeDao.findAttributeByIdDao(attributeId);
            attributeDto = attributeMapper.attributeEntityToGAAttributeDto(attribute);
            return attributeDto;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public GAAttributeDto findAttributeByName(String attributeName) {
        try {
            AttributeEntity attribute;
            GAAttributeDto attributeDto;
            attribute = attributeDao.findAttributeByNameDao(attributeName);
            attributeDto = attributeMapper.attributeEntityToGAAttributeDto(attribute);
            return attributeDto;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<GAttributeDto> findAllAttribute() {
        try {
            List<AttributeEntity> attributeList;
            List<GAttributeDto> attributeDtoList;
            attributeList = attributeDao.findAllAttribute();
            attributeDtoList = attributeList
                    .stream().map(attributeMapper::attributeEntityToGAttributeDto)
                    .collect(Collectors.toList());

            return attributeDtoList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
