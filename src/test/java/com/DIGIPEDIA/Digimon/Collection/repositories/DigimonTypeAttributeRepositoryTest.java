package com.DIGIPEDIA.Digimon.Collection.repositories;

import com.DIGIPEDIA.Digimon.Collection.TestData.Dto.CDtoTestData;
import com.DIGIPEDIA.Digimon.Collection.TestData.Entity.MaxEntityData;
import com.DIGIPEDIA.Digimon.Collection.TestData.TestData;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonTypeAttributeDto.CDigimonTypeAttributeDto;
import com.DIGIPEDIA.Digimon.Collection.entities.DigimonTypeAttributeEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

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

        Optional<DigimonTypeAttributeEntity> optDigimonTypeAttribute = Optional.of(digimonTypeAttribute);

        Mockito.when(digimonTypeAttributeRepository.findByDigimonTypeAttributeId(digimonTypeAttributeId))
                .thenReturn(optDigimonTypeAttribute);

        optDigimonTypeAttribute = this.digimonTypeAttributeRepository.findByDigimonTypeAttributeId(digimonTypeAttributeId);

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

        Optional<DigimonTypeAttributeEntity> optDigimonTypeAttribute = Optional.of(digimonTypeAttribute);

        Mockito.when(digimonTypeAttributeRepository.findByDigimonTypeAttributeName(digimonTypeAttributeName))
                .thenReturn(optDigimonTypeAttribute);

        optDigimonTypeAttribute = this.digimonTypeAttributeRepository.findByDigimonTypeAttributeName(digimonTypeAttributeName);

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
    void createDigimonTypeAttribute(){
        Integer digimonTypeAttributeId = TestData.genericId;

        DigimonTypeAttributeEntity digimonTypeAttribute = MaxEntityData.maxCreateDigimonTypeAttributeEntity();
        CDigimonTypeAttributeDto digimonTypeAttributeDto = CDtoTestData.createDigimonTypeAttributeDto();

        DigimonTypeAttributeEntity digimonTypeAttributeRes = digimonTypeAttribute;
        digimonTypeAttributeRes.setDigimonTypeAttributeId(digimonTypeAttributeId);

        Mockito.when(digimonTypeAttributeRepository.save(digimonTypeAttribute))
                .thenReturn(digimonTypeAttributeRes);

        digimonTypeAttributeRes = this.digimonTypeAttributeRepository.save(digimonTypeAttribute);

        assertNotNull(digimonTypeAttributeRes);
        assertNotNull(digimonTypeAttributeRes.getDigimonTypeAttributeId());
        assertNotNull(digimonTypeAttributeRes.getDigimonTypeId());
        assertNotNull(digimonTypeAttributeRes.getDigimonTypeAttributeName());
        assertNotNull(digimonTypeAttributeRes.getDigimonTypeAttributeImg());

        assertEquals(digimonTypeAttributeDto.getDigimonTypeIdDto(), digimonTypeAttributeRes.getDigimonTypeId());
        assertEquals(digimonTypeAttributeDto.getDigimonTypeAttributeNameDto(), digimonTypeAttributeRes.getDigimonTypeAttributeName());
        assertEquals(digimonTypeAttributeDto.getDigimonTypeAttributeImgDto(), digimonTypeAttributeRes.getDigimonTypeAttributeImg());

    }
}
