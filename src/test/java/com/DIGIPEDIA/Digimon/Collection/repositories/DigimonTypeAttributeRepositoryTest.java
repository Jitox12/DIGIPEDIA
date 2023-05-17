package com.DIGIPEDIA.Digimon.Collection.repositories;

import com.DIGIPEDIA.Digimon.Collection.TestData.Dto.CDtoTestData;
import com.DIGIPEDIA.Digimon.Collection.TestData.Entity.MaxEntityData;
import com.DIGIPEDIA.Digimon.Collection.TestData.TestData;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonTypeAttributeDto.CDigimonTypeAttributeDto;
import com.DIGIPEDIA.Digimon.Collection.entities.DigimonTypeAttributeEntity;
import com.DIGIPEDIA.Digimon.Collection.entities.DigimonTypeEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Base64;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ExtendWith(MockitoExtension.class)
public class DigimonTypeAttributeRepositoryTest {

    @Mock
    private DigimonTypeAttributeRepository digimonTypeAttributeRepository;

    @Test
    void findByDigimonTypeAttributeIdTest(){
        Integer digimonTypeAttributeId = TestData.genericId;

        DigimonTypeAttributeEntity digimonTypeAttribute = MaxEntityData.maxCreateDigimonTypeAttributeEntity();
        digimonTypeAttribute.setDigimonTypeAttributeId(digimonTypeAttributeId);

        Mockito.when(digimonTypeAttributeRepository.findByDigimonTypeAttributeId(digimonTypeAttributeId))
                .thenReturn(Optional.of(digimonTypeAttribute));

        Optional<DigimonTypeAttributeEntity> optDigimonTypeAttribute = this.digimonTypeAttributeRepository.findByDigimonTypeAttributeId(digimonTypeAttributeId);

        assertTrue(optDigimonTypeAttribute.isPresent());

        assertEquals(digimonTypeAttributeId, optDigimonTypeAttribute.get().getDigimonTypeAttributeId());

        assertNotNull(optDigimonTypeAttribute.get().getDigimonTypeId());
        assertNotNull(optDigimonTypeAttribute.get().getAttributeId());
        assertNotNull(optDigimonTypeAttribute.get().getDigimons());
        assertNotNull(optDigimonTypeAttribute.get().getDigimonTypeAttributeName());
        assertNotNull(optDigimonTypeAttribute.get().getDigimonTypeAttributeImg());
        assertNotNull(optDigimonTypeAttribute);
    }

    @Test
    void findByDigimonTypeAttributeName(){
        Integer digimonTypeAttributeId = TestData.genericId;
        String digimonTypeAttributeName = TestData.digimonTypeName;

        DigimonTypeAttributeEntity digimonTypeAttribute = MaxEntityData.maxCreateDigimonTypeAttributeEntity();
        digimonTypeAttribute.setDigimonTypeAttributeId(digimonTypeAttributeId);


        Mockito.when(digimonTypeAttributeRepository.findByDigimonTypeAttributeName(digimonTypeAttributeName))
                .thenReturn(Optional.of(digimonTypeAttribute));

        Optional<DigimonTypeAttributeEntity> optDigimonTypeAttribute = this.digimonTypeAttributeRepository.findByDigimonTypeAttributeName(digimonTypeAttributeName);

        assertTrue(optDigimonTypeAttribute.isPresent());

        assertEquals(digimonTypeAttributeName, optDigimonTypeAttribute.get().getDigimonTypeAttributeName());

        assertNotNull(optDigimonTypeAttribute.get().getDigimonTypeId());
        assertNotNull(optDigimonTypeAttribute.get().getAttributeId());
        assertNotNull(optDigimonTypeAttribute.get().getDigimons());
        assertNotNull(optDigimonTypeAttribute.get().getDigimonTypeAttributeName());
        assertNotNull(optDigimonTypeAttribute.get().getDigimonTypeAttributeImg());
        assertNotNull(optDigimonTypeAttribute);
    }

    @Test
    void createDigimonTypeAttribute(){
        Integer digimonTypeAttributeId = TestData.genericId;

        DigimonTypeAttributeEntity digimonTypeAttribute = MaxEntityData.maxCreateDigimonTypeAttributeEntity();
        CDigimonTypeAttributeDto digimonTypeAttributeDto = CDtoTestData.createDigimonTypeAttributeDto();

        DigimonTypeAttributeEntity digimonTypeAttributeToSave = digimonTypeAttribute;
        digimonTypeAttributeToSave.setDigimonTypeAttributeId(digimonTypeAttributeId);

        Mockito.when(digimonTypeAttributeRepository.save(digimonTypeAttribute))
                .thenReturn(digimonTypeAttributeToSave);

        DigimonTypeAttributeEntity savedDigimonTypeAttributeRes = this.digimonTypeAttributeRepository.save(digimonTypeAttribute);

        assertNotNull(savedDigimonTypeAttributeRes);
        assertNotNull(savedDigimonTypeAttributeRes.getDigimonTypeAttributeId());
        assertNotNull(savedDigimonTypeAttributeRes.getDigimonTypeId());
        assertNotNull(savedDigimonTypeAttributeRes.getDigimonTypeAttributeName());
        assertNotNull(savedDigimonTypeAttributeRes.getDigimonTypeAttributeImg());

        String encoderImg = Base64.getEncoder().encodeToString( digimonTypeAttribute.getDigimonTypeAttributeImg());

        assertEquals(digimonTypeAttributeDto.getDigimonTypeIdDto(), savedDigimonTypeAttributeRes.getDigimonTypeId());
        assertEquals(digimonTypeAttributeDto.getDigimonTypeAttributeImgDto(), encoderImg);
        assertEquals(digimonTypeAttributeDto.getDigimonTypeAttributeNameDto(), savedDigimonTypeAttributeRes.getDigimonTypeAttributeName());

    }
}
