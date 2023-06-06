package com.DIGIPEDIA.Digimon.Collection.dao.daoImpl;

import com.DIGIPEDIA.Digimon.Collection.dao.AttributeDao;
import com.DIGIPEDIA.Digimon.Collection.dto.attributeDto.CAttributeDto;
import com.DIGIPEDIA.Digimon.Collection.entities.AttributeEntity;
import com.DIGIPEDIA.Digimon.Collection.exceptions.BadRequestException;
import com.DIGIPEDIA.Digimon.Collection.repositories.AttributeRepository;
import com.DIGIPEDIA.Digimon.Collection.utils.Base64CoderUtils;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@Component
public class AttributeDaoImpl implements AttributeDao {

    private final AttributeRepository attributeRepository;

    public AttributeDaoImpl( AttributeRepository attributeRepository) {
        this.attributeRepository = attributeRepository;
    }

    @Override
    public void createAttributeDao(CAttributeDto cAttributeDto) throws IOException {

        byte[] bytes = Base64CoderUtils.base64Decoder(cAttributeDto.getAttributeImgDto());

        AttributeEntity attribute = AttributeEntity.builder()
                .attributeName(cAttributeDto.getAttributeNameDto())
                .attributeImg(bytes)
                .build();

        attributeRepository.save(attribute);
    }
    @Transactional
    @Override
    public List<AttributeEntity> findAllAttribute() throws IOException {
        List<AttributeEntity> attributeList;

        attributeList = attributeRepository.findAll();
        return attributeList;
    }
    @Transactional
    @Override
    public AttributeEntity findAttributeByIdDao(Integer attributeId) throws IOException {
        AttributeEntity attribute;

        attribute = attributeRepository.findByAttributeId(attributeId)
                .orElseThrow(()-> new BadRequestException("Attribute id: ".concat(String.valueOf(attributeId))));

        return attribute;
    }

    @Transactional
    @Override
    public AttributeEntity findAttributeByNameDao(String attributeName) throws IOException {
        AttributeEntity attribute;

        attribute = attributeRepository.findByAttributeName(attributeName)
                .orElseThrow(()-> new BadRequestException("Attribute Name :".concat(attributeName)));

        return attribute;
    }
}