package com.DIGIPEDIA.Digimon.Collection.repositories;


import com.DIGIPEDIA.Digimon.Collection.TestData.Entity.MaxEntityData;
import com.DIGIPEDIA.Digimon.Collection.TestData.TestData;
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

        Optional<SkillEntity> optSkill = Optional.of(skill);

        Mockito.when(skillRepository.findBySkillId(skillId))
                .thenReturn(optSkill);

        optSkill = skillRepository.findBySkillId(skillId);

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

        Optional<SkillEntity> optSkill = Optional.of(skill);

        Mockito.when(skillRepository.findBySkillName(skillName))
                .thenReturn(optSkill);

        optSkill = skillRepository.findBySkillName(skillName);

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

        SkillEntity skillRes = skill;
        skill.setSkillId(skillId);

        Mockito.when(skillRepository.save(skill))
                .thenReturn(skillRes);

        skillRes = this.skillRepository.save(skill);

        assertNotNull(skillRes);
        assertNotNull(skillRes.getSkillId());
        assertNotNull(skillRes.getSkillName());
        assertNotNull(skillRes.getSkillDescription());
        assertNotNull(skillRes.getSkill_type());
        assertNotNull(skillRes.getDigimons());
        assertNotNull(skillRes.getAttribute());
    }
}
