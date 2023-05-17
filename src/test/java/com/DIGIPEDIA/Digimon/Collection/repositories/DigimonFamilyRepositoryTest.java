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


        Mockito.when(digimonFamilyRepository.findByDigimonFamilyId(digimonFamily.getDigimonFamilyId()))
                .thenReturn(Optional.of(digimonFamily));
        Optional<DigimonFamilyEntity> optDigimonFamily = this.digimonFamilyRepository.findByDigimonFamilyId(digimonFamilyId);

        assertTrue(optDigimonFamily.isPresent());
        assertEquals(digimonFamily.getDigimonFamilyId(), optDigimonFamily.get().getDigimonFamilyId());
        assertNotNull(optDigimonFamily);
    }

    @Test
    public void findByDigimonFamilyNameTest() {

        String digimonFamilyName = TestData.digimonFamilyName;

        DigimonFamilyEntity digimonFamily = MaxEntityData.maxCreateDigimonFamily();


        Mockito.when(digimonFamilyRepository.findByDigimonFamilyName(digimonFamilyName))
                .thenReturn(Optional.of(digimonFamily));
        Optional<DigimonFamilyEntity> optDigimonFamily = this.digimonFamilyRepository.findByDigimonFamilyName(digimonFamilyName);

        assertTrue(optDigimonFamily.isPresent());
        assertEquals(digimonFamily.getDigimonFamilyName(), optDigimonFamily.get().getDigimonFamilyName());
        assertNotNull(optDigimonFamily);

    }

    @Test
    public void createDigimonFamilyTest() {
        Integer digimonFamilyId = 1;

        DigimonFamilyEntity digimonFamily = MaxEntityData.maxCreateDigimonFamily();
        CDigimonFamilyDto digimonFamilyDto = CDtoTestData.createDigimonFamilyDto();

        DigimonFamilyEntity digimonFamilyToSave = digimonFamily;
        digimonFamilyToSave.setDigimonFamilyId(digimonFamilyId);

        Mockito.when(digimonFamilyRepository.save(digimonFamily))
                .thenReturn(digimonFamilyToSave);

        DigimonFamilyEntity savedDigimonFamily = this.digimonFamilyRepository.save(digimonFamily);

        assertEquals(digimonFamilyDto.getDigimonFamilyNameDto(), savedDigimonFamily.getDigimonFamilyName());

        assertEquals(savedDigimonFamily.getDigimonFamilyName(), digimonFamily.getDigimonFamilyName());
        assertNotNull(savedDigimonFamily.getDigimonFamilyId());
        assertNotNull(savedDigimonFamily);
    }
}
