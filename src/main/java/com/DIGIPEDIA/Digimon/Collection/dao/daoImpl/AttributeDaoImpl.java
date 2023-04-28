package com.DIGIPEDIA.Digimon.Collection.dao.daoImpl;

import com.DIGIPEDIA.Digimon.Collection.dao.AttributeDao;
import com.DIGIPEDIA.Digimon.Collection.dto.attributeDto.CAttributeDto;
import com.DIGIPEDIA.Digimon.Collection.entities.AttributeEntity;
import com.DIGIPEDIA.Digimon.Collection.repositories.AttributeRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AttributeDaoImpl implements AttributeDao {

    private final AttributeRepository attributeRepository;

    public AttributeDaoImpl(AttributeRepository attributeRepository) {
        this.attributeRepository = attributeRepository;
    }

    @Override
    public void createAttributeDao(CAttributeDto cAttributeDto) {
        AttributeEntity attribute = AttributeEntity
                .builder()
                .attributeName(cAttributeDto.getAttributeNameDto())
                .build();

        attributeRepository.save(attribute);
    }

    @Override
    public List<AttributeEntity> findAllAttribute() {
        List<AttributeEntity> attributeList;

        attributeList = attributeRepository.findAll();

        return attributeList;
    }

    @Override
    public AttributeEntity findAttributeByIdDao(Integer attributeId) {
        AttributeEntity attribute;

        attribute = attributeRepository.findByAttributeId(attributeId);

        return attribute;
    }

    @Override
    public AttributeEntity findAttributeByNameDao(String attributeName) {
        AttributeEntity attribute;

        attribute = attributeRepository.findByAttributeName(attributeName);

        return attribute;
    }
}
