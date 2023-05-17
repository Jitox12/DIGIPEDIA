package com.DIGIPEDIA.Digimon.Collection.dao;

import com.DIGIPEDIA.Digimon.Collection.TestData.Dto.CDtoTestData;
import com.DIGIPEDIA.Digimon.Collection.TestData.Entity.MaxEntityData;
import com.DIGIPEDIA.Digimon.Collection.TestData.TestData;
import com.DIGIPEDIA.Digimon.Collection.dao.daoImpl.AttributeDaoImpl;
import com.DIGIPEDIA.Digimon.Collection.dto.attributeDto.CAttributeDto;
import com.DIGIPEDIA.Digimon.Collection.entities.AttributeEntity;
import com.DIGIPEDIA.Digimon.Collection.repositories.AttributeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class AttributeDaoTest {

    @Mock
    private AttributeRepository attributeRepository;

    @InjectMocks
    private AttributeDaoImpl attributeDaoImpl;


    @Test
    void findAttributeByIdDaoTest() throws IOException {

        Integer attributeId = TestData.genericId;

        AttributeEntity attribute = MaxEntityData.maxCreateAttributeEntity();
        attribute.setAttributeId(attributeId);

        Mockito.when(attributeRepository.findByAttributeId(attributeId))
                .thenReturn(Optional.of(attribute));

        AttributeEntity AttributeRes = attributeDaoImpl.findAttributeByIdDao(attributeId);

        assertEquals(attributeId, AttributeRes.getAttributeId());

        assertNotNull(AttributeRes.getAttributeName());
        assertNotNull(AttributeRes.getAttributeImg());
        assertNotNull(AttributeRes.getSkills());
        assertNotNull(AttributeRes.getDigimonTypesAttribute());
        assertNotNull(AttributeRes.getAttributeId());
        assertNotNull(AttributeRes);
    }

    @Test
    void findAttributeByNameDaoText() throws IOException{
        String attributeName = TestData.attributeName;
        Integer attributeId = TestData.genericId;

        AttributeEntity attribute = MaxEntityData.maxCreateAttributeEntity();
        attribute.setAttributeId(attributeId);

        Mockito.when(attributeRepository.findByAttributeName(attributeName))
                .thenReturn(Optional.of(attribute));

        AttributeEntity AttributeRes = attributeDaoImpl.findAttributeByNameDao(attributeName);

        assertEquals(attributeName, AttributeRes.getAttributeName());

        assertNotNull(AttributeRes.getAttributeName());
        assertNotNull(AttributeRes.getAttributeImg());
        assertNotNull(AttributeRes.getSkills());
        assertNotNull(AttributeRes.getDigimonTypesAttribute());
        assertNotNull(AttributeRes.getAttributeId());
        assertNotNull(AttributeRes);
    }

    @Test
    void createAttributeDaoTest() throws IOException {
        Integer attributeId = TestData.genericId;

        AttributeEntity attribute = MaxEntityData.maxCreateAttributeEntity();
        attribute.setAttributeId(attributeId);

        CAttributeDto attributeDto = CDtoTestData.createAttributeDto();

        Mockito.when(attributeRepository.save(Mockito.any()))
                .thenReturn(attribute);

        attributeDaoImpl.createAttributeDao(attributeDto);

        Mockito.verify(attributeRepository, Mockito.times(1)).save(Mockito.any());
    }

    @Test
    void findAllAttributeDaoTest() throws IOException{
        Integer attributeId = TestData.genericId;

        AttributeEntity attribute = MaxEntityData.maxCreateAttributeEntity();
        attribute.setAttributeId(attributeId);

        List<AttributeEntity> attributeEntityList = new ArrayList<>();
        attributeEntityList.add(attribute);
        attributeEntityList.add(attribute);
        attributeEntityList.add(attribute);

        Mockito.when(attributeRepository.findAll())
                .thenReturn(attributeEntityList);

        List<AttributeEntity> attributeListRes = attributeDaoImpl.findAllAttribute();

        assertNotNull(attributeListRes);
        attributeListRes.forEach(attributeE -> {
            assertNotNull(attributeE.getAttributeName());
            assertNotNull(attributeE.getAttributeImg());
            assertNotNull(attributeE.getAttributeId());
        });
    }
}