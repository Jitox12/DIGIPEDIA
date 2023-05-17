package com.DIGIPEDIA.Digimon.Collection.repositories;


import com.DIGIPEDIA.Digimon.Collection.TestData.Dto.CDtoTestData;
import com.DIGIPEDIA.Digimon.Collection.TestData.Entity.MaxEntityData;
import com.DIGIPEDIA.Digimon.Collection.TestData.TestData;
import com.DIGIPEDIA.Digimon.Collection.dto.skillDto.CSkillDto;
import com.DIGIPEDIA.Digimon.Collection.entities.SkillEntity;
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
public class SkillRepositoryTest {

    @Mock
    SkillRepository skillRepository;

    @Test
    void findBySkillId(){
        Integer skillId = TestData.genericId;

        SkillEntity skill = MaxEntityData.maxCreateSkillEntity();
        skill.setSkillId(skillId);


        Mockito.when(skillRepository.findBySkillId(skillId))
                .thenReturn(Optional.of(skill));

        Optional<SkillEntity> optSkill = skillRepository.findBySkillId(skillId);

        assertNotNull(optSkill);
        assertNotNull(optSkill.get().getSkillId());
        assertNotNull(optSkill.get().getSkillName());
        assertNotNull(optSkill.get().getSkillDescription());
        assertNotNull(optSkill.get().getSkill_type());
        assertNotNull(optSkill.get().getDigimons());
        assertNotNull(optSkill.get().getAttribute());

        assertEquals(optSkill.get().getSkillId(), skillId);

    }

    @Test
    void findBySkillName(){
        Integer skillId = TestData.genericId;
        String skillName = TestData.skillName;

        SkillEntity skill = MaxEntityData.maxCreateSkillEntity();
        skill.setSkillId(skillId);


        Mockito.when(skillRepository.findBySkillName(skillName))
                .thenReturn(Optional.of(skill));

        Optional<SkillEntity> optSkill = skillRepository.findBySkillName(skillName);

        assertNotNull(optSkill);
        assertNotNull(optSkill.get().getSkillId());
        assertNotNull(optSkill.get().getSkillName());
        assertNotNull(optSkill.get().getSkillDescription());
        assertNotNull(optSkill.get().getSkill_type());
        assertNotNull(optSkill.get().getDigimons());
        assertNotNull(optSkill.get().getAttribute());

        assertEquals(optSkill.get().getSkillName(), skillName);
    }

    @Test
    void createSkillTest(){
        Integer skillId = TestData.genericId;

        SkillEntity skill = MaxEntityData.maxCreateSkillEntity();
        CSkillDto skillDto = CDtoTestData.createSkillDto();

        SkillEntity skillToSave = skill;
        skillToSave.setSkillId(skillId);

        Mockito.when(skillRepository.save(skill))
                .thenReturn(skillToSave);

        SkillEntity savedSkill = this.skillRepository.save(skill);

       assertEquals(skillDto.getSkillNameDto(), savedSkill.getSkillName());
       assertEquals(skillDto.getSkillDescriptionDto(),savedSkill.getSkillDescription());
       assertEquals(skillDto.getSkillTypeIdDto(), savedSkill.getSkillTypeId());

        assertNotNull(savedSkill);
        assertNotNull(savedSkill.getSkillId());
        assertNotNull(savedSkill.getSkillName());
        assertNotNull(savedSkill.getSkillDescription());
        assertNotNull(savedSkill.getSkill_type());
        assertNotNull(savedSkill.getDigimons());
        assertNotNull(savedSkill.getAttribute());
    }
}
