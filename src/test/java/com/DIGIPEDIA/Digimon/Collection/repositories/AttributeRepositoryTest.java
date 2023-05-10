package com.DIGIPEDIA.Digimon.Collection.repositories;

import com.DIGIPEDIA.Digimon.Collection.TestData.EntityTestData;
import com.DIGIPEDIA.Digimon.Collection.TestData.MaxEntityData;
import com.DIGIPEDIA.Digimon.Collection.dto.attributeDto.CAttributeDto;
import com.DIGIPEDIA.Digimon.Collection.entities.AttributeEntity;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
@ExtendWith(MockitoExtension.class)
public class AttributeRepositoryTest {

    @Mock
    private  AttributeRepository attributeRepository;

    @Test
    public void findByAttributeIdTest() {

        byte[] img = EntityTestData.img;

        AttributeEntity attribute = MaxEntityData.maxCreateAttributeEntity();

        Optional<AttributeEntity> optAttribute= Optional.of(attribute);

        Mockito.when(attributeRepository.findByAttributeId(attribute.getAttributeId())).thenReturn(optAttribute);
        optAttribute = this.attributeRepository.findByAttributeId(1);

        assertTrue(optAttribute.isPresent());
        assertEquals(attribute.getAttributeId(), optAttribute.get().getAttributeId());
        assertNotNull(optAttribute);
    }

    @Test
    public void findByAttributeNameTest() {
        //Inicializa Imagen
        byte[] img = EntityTestData.img;

        AttributeEntity attribute = MaxEntityData.maxCreateAttributeEntity();

        Optional<AttributeEntity> optAttribute= Optional.of(attribute);

        Mockito.when(attributeRepository.findByAttributeName(attribute.getAttributeName())).thenReturn(optAttribute);
        optAttribute = this.attributeRepository.findByAttributeName("Fuego");

        assertTrue(optAttribute.isPresent());
        assertEquals(attribute.getAttributeName(), optAttribute.get().getAttributeName());
        assertNotNull(optAttribute);
    }

    @Test
    public void createAttributeTest(){

        byte[] img = EntityTestData.img;

        AttributeEntity attribute = MaxEntityData.maxCreateAttributeEntity();

        CAttributeDto attributeDto = new CAttributeDto("Fuego", img );

        AttributeEntity attributeEntitySave = AttributeEntity
                .builder()
                .attributeName(attributeDto.getAttributeNameDto())
                .attributeImg(attributeDto.getAttributeImgDto())
                .build();


        Mockito.when(attributeRepository.save(attributeEntitySave)).thenReturn(attribute);
        attribute = this.attributeRepository.save(attributeEntitySave);

        assertEquals(attribute.getAttributeName(), attributeDto.getAttributeNameDto());
        assertEquals(attribute.getAttributeImg(), attributeDto.getAttributeImgDto());
        assertNotNull(attribute);
    }
}