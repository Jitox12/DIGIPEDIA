package com.DIGIPEDIA.Digimon.Collection.dao.daoImpl;

import com.DIGIPEDIA.Digimon.Collection.dao.AttributeDao;
import com.DIGIPEDIA.Digimon.Collection.dto.attributeDto.CAttributeDto;
import com.DIGIPEDIA.Digimon.Collection.entities.AttributeEntity;
import com.DIGIPEDIA.Digimon.Collection.exceptions.NotFoundException;
import com.DIGIPEDIA.Digimon.Collection.repositories.AttributeRepository;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Component
public class AttributeDaoImpl implements AttributeDao {

    private final AttributeRepository attributeRepository;

    public AttributeDaoImpl(AttributeRepository attributeRepository) {
        this.attributeRepository = attributeRepository;
    }

    @Override
    public void createAttributeDao(CAttributeDto cAttributeDto) throws IOException{
        AttributeEntity attribute = AttributeEntity
                .builder()
                .attributeName(cAttributeDto.getAttributeNameDto())
                .build();

        attributeRepository.save(attribute);
    }

    @Override
    public List<AttributeEntity> findAllAttribute() throws IOException{
        List<AttributeEntity> attributeList;

        attributeList = attributeRepository.findAll();

        return attributeList;
    }

    @Override
    public AttributeEntity findAttributeByIdDao(Integer attributeId) throws IOException{
        AttributeEntity attribute;
        attribute = attributeRepository.findByAttributeId(attributeId)
                .orElseThrow(()->  new NotFoundException("attribute with id: ".concat(String.valueOf(attributeId))));

        return attribute;
    }

    @Override
    public AttributeEntity findAttributeByNameDao(String attributeName) throws IOException{
        AttributeEntity attribute;
        attribute = attributeRepository.findByAttributeName(attributeName)
                .orElseThrow(()->  new NotFoundException("attribute with name: ".concat(attributeName)));

        return attribute;
    }
}
