package com.DIGIPEDIA.Digimon.Collection.repositories;

import com.DIGIPEDIA.Digimon.Collection.TestData.Entity.MaxEntityData;
import com.DIGIPEDIA.Digimon.Collection.TestData.TestData;
import com.DIGIPEDIA.Digimon.Collection.entities.DigimonTypeEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@ExtendWith(MockitoExtension.class)
public class DigimonTypeRepositoryTest {

    @Mock
    DigimonTypeRepository digimonTypeRepository;

    @Test
    void findByDigimonTypeIdTest() {
        Integer digimonTypeId = TestData.genericId;

        DigimonTypeEntity digimonType = MaxEntityData.maxCreateDigimonTypeEntity();

        digimonType.setDigimonTypeId(digimonTypeId);

        Optional<DigimonTypeEntity> optDigimonType = Optional.of(digimonType);

        Mockito.when(digimonTypeRepository.findByDigimonTypeId(digimonTypeId))
                .thenReturn(optDigimonType);

        optDigimonType = this.digimonTypeRepository.findByDigimonTypeId(digimonTypeId);

        assertNotNull(optDigimonType);
        assertNotNull(optDigimonType.get().getDigimonTypeId());
        assertNotNull(optDigimonType.get().getDigimonTypeAttribute());
        assertNotNull(optDigimonType.get().getDigimonTypeAttribute());

        assertEquals(digimonTypeId, optDigimonType.get().getDigimonTypeId());

    }

    @Test
    void findByDigimonTypeNameTest(){
        Integer digimonTypeId = TestData.genericId;
        String digimonTypeName = TestData.digimonTypeName;

        DigimonTypeEntity digimonType = MaxEntityData.maxCreateDigimonTypeEntity();
        digimonType.setDigimonTypeId(digimonTypeId);

        Optional<DigimonTypeEntity> optDigimonType = Optional.of(digimonType);

        Mockito.when(digimonTypeRepository.findByDigimonTypeName(digimonTypeName))
                .thenReturn(optDigimonType);

        optDigimonType = this.digimonTypeRepository.findByDigimonTypeName(digimonTypeName);

        assertNotNull(optDigimonType);
        assertNotNull(optDigimonType.get().getDigimonTypeId());
        assertNotNull(optDigimonType.get().getDigimonTypeAttribute());
        assertNotNull(optDigimonType.get().getDigimonTypeAttribute());

        assertEquals(digimonTypeId, optDigimonType.get().getDigimonTypeId());
    }

    @Test
    void createDigimonTypeEntity(){
        Integer digimonTypeId = TestData.genericId;

        DigimonTypeEntity digimonType = MaxEntityData.maxCreateDigimonTypeEntity();

        DigimonTypeEntity digimonTypeRes = digimonType;
        digimonTypeRes.setDigimonTypeId(digimonTypeId);

        Mockito.when(digimonTypeRepository.save(digimonType))
                .thenReturn(digimonTypeRes);

        digimonTypeRes = digimonTypeRepository.save(digimonType);

        assertNotNull(digimonTypeRes);
        assertNotNull(digimonTypeRes.getDigimonTypeId());
        assertNotNull(digimonTypeRes.getDigimonTypeAttribute());
        assertNotNull(digimonTypeRes.getDigimonTypeAttribute());
    }
}
