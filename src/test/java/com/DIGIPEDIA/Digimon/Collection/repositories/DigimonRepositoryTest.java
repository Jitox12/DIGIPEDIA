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

        Optional<DigimonEntity> optDigimon = Optional.of(digimon);

        Optional<DigimonEntity> optDigimonRes;

        Mockito.when(digimonRepository.findByDigimonId(digimonId))
                .thenReturn(optDigimon);

        optDigimonRes = this.digimonRepository.findByDigimonId(1);

        assertTrue(optDigimonRes.isPresent());
        assertEquals(digimonId, optDigimonRes.get().getDigimonId());
        assertNotNull(optDigimonRes);
    }

    @Test
    void findByDigimonNameTest(){
        String digimonName = TestData.digimonName;
        Integer digimonId = 1;

        DigimonEntity digimon = MaxEntityData.maxCreateDigimonEntity();

        digimon.setDigimonId(digimonId);

        Optional<DigimonEntity> optDigimon = Optional.of(digimon);


        Optional<DigimonEntity> optDigimonRes;

        Mockito.when(digimonRepository.findByDigimonName(digimonName))
                .thenReturn(optDigimon);

        optDigimonRes = this.digimonRepository.findByDigimonName(digimonName);

        assertTrue(optDigimonRes.isPresent());
        assertEquals(digimonName, optDigimonRes.get().getDigimonName());
        assertNotNull(optDigimonRes);
    }

    @Test
    void createDigimonTest(){
        Integer digimonId = 1;
        
        DigimonEntity digimon = MaxEntityData.maxCreateDigimonEntity();
        CDigimonDto digimonDto = CDtoTestData.createDigimonDto();

        DigimonEntity digimonRes = digimon;
        digimonRes.setDigimonId(digimonId);

        Mockito.when(digimonRepository.save(digimon))
                .thenReturn(digimonRes);
        digimonRes = this.digimonRepository.save(digimon);

        assertEquals(digimonDto.getDigimonNameDto(), digimonRes.getDigimonName());
        assertNotNull(digimonRes.getDigimon_family());
        assertNotNull(digimonRes.getDigimonImg());
        assertNotNull(digimonRes.getDigimonMemory());
        assertNotNull(digimonRes.getDigimonPassive());
        assertNotNull(digimonRes.getDigimon_type_attribute());
        assertNotNull(digimonRes);
    }

}
