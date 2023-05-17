package com.DIGIPEDIA.Digimon.Collection.repositories;

import com.DIGIPEDIA.Digimon.Collection.TestData.Entity.MaxEntityData;
import com.DIGIPEDIA.Digimon.Collection.TestData.TestData;
import com.DIGIPEDIA.Digimon.Collection.entities.DigimonSkillEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@ExtendWith(MockitoExtension.class)
public class DigimonSkillRespositoryTest {

    @Mock
    private DigimonSkillRepository digimonSkillRepository;

    @Test
    void createDigimonSkillTest() {
        Integer digimonSkillId = TestData.genericId;
        AtomicInteger i = new AtomicInteger(digimonSkillId);

        List<DigimonSkillEntity> digimonSkillList = MaxEntityData.maxCreateDigimonSkillEntity();

        List<DigimonSkillEntity> digimonSkillToSave = digimonSkillList;

        digimonSkillToSave.forEach((digimonSkill) -> {
            digimonSkill.setDigimonSkillId(i.getAndIncrement());
        });

        Mockito.when(digimonSkillRepository.saveAll(digimonSkillList))
                .thenReturn(digimonSkillToSave);

        List<DigimonSkillEntity> savedDigimonSkill = this.digimonSkillRepository.saveAll(digimonSkillList);

        savedDigimonSkill.forEach(digimonSkill -> {
            assertNotNull(digimonSkill.getDigimonId());
            assertNotNull(digimonSkill.getDigimonSkillId());
            assertNotNull(digimonSkill.getSkillId());

            assertEquals(digimonSkillId, digimonSkill.getDigimonId());
        });

    }
}
