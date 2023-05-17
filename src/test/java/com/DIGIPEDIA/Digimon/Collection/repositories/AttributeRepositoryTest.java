package com.DIGIPEDIA.Digimon.Collection.repositories;

import com.DIGIPEDIA.Digimon.Collection.TestData.Dto.CDtoTestData;
import com.DIGIPEDIA.Digimon.Collection.TestData.Entity.MaxEntityData;
import com.DIGIPEDIA.Digimon.Collection.TestData.TestData;
import com.DIGIPEDIA.Digimon.Collection.dto.attributeDto.CAttributeDto;
import com.DIGIPEDIA.Digimon.Collection.entities.AttributeEntity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Base64;
import java.util.Optional;

@DataJpaTest
@ExtendWith(MockitoExtension.class)
public class AttributeRepositoryTest {

    @Mock
    private AttributeRepository attributeRepository;

    @Test
    public void findByAttributeIdTest() {
        Integer attributeId = 1;

        AttributeEntity attribute = MaxEntityData.maxCreateAttributeEntity();
        attribute.setAttributeId(attributeId);

        Mockito.when(attributeRepository.findByAttributeId(attributeId))
                .thenReturn(Optional.of(attribute));

        Optional<AttributeEntity> optAttribute = this.attributeRepository.findByAttributeId(attributeId);

        assertTrue(optAttribute.isPresent());
        assertEquals(attributeId, optAttribute.get().getAttributeId());
        assertNotNull(optAttribute);
    }

    @Test
    public void findByAttributeNameTest() {
        Integer attributeId = 1;
        String attributeName = TestData.attributeName;

        AttributeEntity attribute = MaxEntityData.maxCreateAttributeEntity();
        attribute.setAttributeId(attributeId);

        Mockito.when(attributeRepository.findByAttributeName(attributeName))
                .thenReturn(Optional.of(attribute));
        Optional<AttributeEntity> optAttribute = this.attributeRepository.findByAttributeName(attributeName);

        assertTrue(optAttribute.isPresent());
        assertEquals(attribute.getAttributeName(), optAttribute.get().getAttributeName());
        assertEquals(attribute.getAttributeImg(), optAttribute.get().getAttributeImg());
        assertNotNull(optAttribute);
    }

    @Test
    public void createAttributeTest() {
        Integer attributeId = 1;

        AttributeEntity attribute = MaxEntityData.maxCreateAttributeEntity();
        CAttributeDto attributeDto = CDtoTestData.createAttributeDto();

        AttributeEntity attributeToSave = attribute;
        attributeToSave.setAttributeId(attributeId);

        Mockito.when(attributeRepository.save(attribute))
                .thenReturn(attributeToSave);
        AttributeEntity savedAttribute = this.attributeRepository.save(attribute);

        String encoderImg = Base64.getEncoder().encodeToString(savedAttribute.getAttributeImg());

        assertEquals(savedAttribute.getAttributeName(), attributeDto.getAttributeNameDto());
        assertEquals(encoderImg, attributeDto.getAttributeImgDto());

        assertNotNull(savedAttribute.getAttributeId());
        assertNotNull(savedAttribute);
    }
}