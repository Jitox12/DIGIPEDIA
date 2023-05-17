package com.DIGIPEDIA.Digimon.Collection.repositories;

import com.DIGIPEDIA.Digimon.Collection.TestData.Dto.CDtoTestData;
import com.DIGIPEDIA.Digimon.Collection.TestData.Entity.MaxEntityData;
import com.DIGIPEDIA.Digimon.Collection.TestData.TestData;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonDto.CDigimonDto;
import com.DIGIPEDIA.Digimon.Collection.entities.DigimonEntity;
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
public class DigimonRepositoryTest {

    @Mock
    private DigimonRepository digimonRepository;

    @Test
    void findByDigimonIdTest(){
        Integer digimonId = 1;

        DigimonEntity digimon = MaxEntityData.maxCreateDigimonEntity();
        digimon.setDigimonId(digimonId);


        Mockito.when(digimonRepository.findByDigimonId(digimonId))
                .thenReturn(Optional.of(digimon));

        Optional<DigimonEntity> optDigimon = this.digimonRepository.findByDigimonId(1);

        assertTrue(optDigimon.isPresent());
        assertEquals(digimonId, optDigimon.get().getDigimonId());
        assertNotNull(optDigimon);
    }

    @Test
    void findByDigimonNameTest(){
        String digimonName = TestData.digimonName;
        Integer digimonId = 1;

        DigimonEntity digimon = MaxEntityData.maxCreateDigimonEntity();
        digimon.setDigimonId(digimonId);

        Mockito.when(digimonRepository.findByDigimonName(digimonName))
                .thenReturn(Optional.of(digimon));

        Optional<DigimonEntity> optDigimon = this.digimonRepository.findByDigimonName(digimonName);

        assertTrue(optDigimon.isPresent());
        assertEquals(digimonName, optDigimon.get().getDigimonName());
        assertNotNull(optDigimon);
    }

    @Test
    void createDigimonTest(){
        Integer digimonId = 1;
        
        DigimonEntity digimon = MaxEntityData.maxCreateDigimonEntity();
        CDigimonDto digimonDto = CDtoTestData.createDigimonDto();

        DigimonEntity digimonToSave = digimon;
        digimonToSave.setDigimonId(digimonId);

        Mockito.when(digimonRepository.save(digimon))
                .thenReturn(digimonToSave);
        DigimonEntity savedDigimon = this.digimonRepository.save(digimon);

        String encoderImg = Base64.getEncoder().encodeToString(savedDigimon.getDigimonImg());


        assertEquals(digimonDto.getDigimonNameDto(), savedDigimon.getDigimonName());
        assertEquals(digimonDto.getDigimonImgDto(),encoderImg );
        assertEquals(digimonDto.getDigimonMemoryDto(), savedDigimon.getDigimonMemory());
        assertEquals(digimonDto.getDigimonFamilyIdDto(), savedDigimon.getDigimonFamilyId());
        assertEquals(digimonDto.getDigimonPassiveDto(), savedDigimon.getDigimonPassive());
        assertEquals(digimonDto.getDigimonTypeAttributeIdDto(), savedDigimon.getDigimonTypeAttributeId());

        assertNotNull(savedDigimon.getSkills());
        assertNotNull(savedDigimon.getDigimon_family());
        assertNotNull(savedDigimon.getDigimon_type_attribute());
        assertNotNull(savedDigimon.getDigimonImg());
        assertNotNull(savedDigimon.getDigimonMemory());
        assertNotNull(savedDigimon.getDigimonPassive());

        assertNotNull(savedDigimon);
    }

}
