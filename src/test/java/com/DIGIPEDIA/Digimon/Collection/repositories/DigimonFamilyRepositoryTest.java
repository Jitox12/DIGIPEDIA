package com.DIGIPEDIA.Digimon.Collection.repositories;

import com.DIGIPEDIA.Digimon.Collection.TestData.Dto.CDtoTestData;
import com.DIGIPEDIA.Digimon.Collection.TestData.Entity.MaxEntityData;
import com.DIGIPEDIA.Digimon.Collection.TestData.TestData;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonFamilyDto.CDigimonFamilyDto;
import com.DIGIPEDIA.Digimon.Collection.entities.DigimonFamilyEntity;
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
public class DigimonFamilyRepositoryTest {

    @Mock
    private DigimonFamilyRepository digimonFamilyRepository;

    @Test
    public void findByDigimonFamilyIdTest() {

        Integer digimonFamilyId = 1;

        DigimonFamilyEntity digimonFamily = MaxEntityData.maxCreateDigimonFamily();
        digimonFamily.setDigimonFamilyId(digimonFamilyId);


        Optional<DigimonFamilyEntity> optDigimonFamily = Optional.of(digimonFamily);

        Mockito.when(digimonFamilyRepository.findByDigimonFamilyId(digimonFamily.getDigimonFamilyId()))
                .thenReturn(optDigimonFamily);
        optDigimonFamily = this.digimonFamilyRepository.findByDigimonFamilyId(digimonFamilyId);

        assertTrue(optDigimonFamily.isPresent());
        assertEquals(digimonFamily.getDigimonFamilyId(), optDigimonFamily.get().getDigimonFamilyId());
        assertNotNull(optDigimonFamily);
    }

    @Test
    public void findByDigimonFamilyNameTest() {

        String digimonFamilyName = TestData.digimonFamilyName;

        DigimonFamilyEntity digimonFamily = MaxEntityData.maxCreateDigimonFamily();

        Optional<DigimonFamilyEntity> optDigimonFamily = Optional.of(digimonFamily);

        Mockito.when(digimonFamilyRepository.findByDigimonFamilyName(digimonFamilyName))
                .thenReturn(optDigimonFamily);
        optDigimonFamily = this.digimonFamilyRepository.findByDigimonFamilyName(digimonFamilyName);

        assertTrue(optDigimonFamily.isPresent());
        assertEquals(digimonFamily.getDigimonFamilyName(), optDigimonFamily.get().getDigimonFamilyName());
        assertNotNull(optDigimonFamily);

    }

    @Test
    public void createDigimonFamilyTest() {
        Integer digimonFamilyId = 1;

        DigimonFamilyEntity digimonFamily = MaxEntityData.maxCreateDigimonFamily();
        CDigimonFamilyDto digimonFamilyDto = CDtoTestData.createDigimonFamilyDto();

        DigimonFamilyEntity digimonFamilyRes = digimonFamily;
        digimonFamilyRes.setDigimonFamilyId(digimonFamilyId);

        Mockito.when(digimonFamilyRepository.save(digimonFamily))
                .thenReturn(digimonFamilyRes);

        digimonFamilyRes = this.digimonFamilyRepository.save(digimonFamily);

        assertEquals(digimonFamilyDto.getDigimonFamilyNameDto(), digimonFamilyRes.getDigimonFamilyName());
        assertEquals(digimonFamilyRes.getDigimonFamilyName(), digimonFamily.getDigimonFamilyName());
        assertNotNull(digimonFamilyRes.getDigimonFamilyId());
        assertNotNull(digimonFamilyRes);
    }
}
