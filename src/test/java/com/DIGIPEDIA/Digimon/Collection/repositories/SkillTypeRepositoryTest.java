package com.DIGIPEDIA.Digimon.Collection.repositories;

import com.DIGIPEDIA.Digimon.Collection.TestData.Dto.CDtoTestData;
import com.DIGIPEDIA.Digimon.Collection.TestData.Entity.MaxEntityData;
import com.DIGIPEDIA.Digimon.Collection.TestData.TestData;
import com.DIGIPEDIA.Digimon.Collection.dto.skillTypeDto.CSkillTypeDto;
import com.DIGIPEDIA.Digimon.Collection.entities.SkillTypeEntity;
import static org.junit.jupiter.api.Assertions.*;

import org.h2.value.DataType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
@ExtendWith(MockitoExtension.class)
public class SkillTypeRepositoryTest {
    @Mock
    SkillTypeRepository skillTypeRepository;

    @Test
    void findBySkillTypeId(){
        Integer skillTypeId = TestData.genericId;

        SkillTypeEntity skillType = MaxEntityData.maxCreateSkillTypeEntity();
        skillType.setSkillTypeId(skillTypeId);


        Mockito.when(skillTypeRepository.findBySkillTypeId(skillTypeId))
                .thenReturn(Optional.of(skillType));

        Optional<SkillTypeEntity> optSkillType = skillTypeRepository.findBySkillTypeId(skillTypeId);

        assertNotNull(optSkillType);
        assertNotNull(optSkillType.get().getSkillTypeId());
        assertNotNull(optSkillType.get().getSkills());
        assertNotNull(optSkillType.get().getSkillTypeName());

        assertEquals(optSkillType.get().getSkillTypeId(), skillTypeId);
    }

    @Test
    void findBySkillTypeName(){
        Integer skillTypeId = TestData.genericId;
        String skillTypeName = TestData.skillTypeName;


        SkillTypeEntity skillType = MaxEntityData.maxCreateSkillTypeEntity();
        skillType.setSkillTypeId(skillTypeId);


        Mockito.when(skillTypeRepository.findBySkillTypeName(skillTypeName))
                .thenReturn(Optional.of(skillType));

        Optional<SkillTypeEntity> optSkillType = skillTypeRepository.findBySkillTypeName(skillTypeName);

        assertNotNull(optSkillType);
        assertNotNull(optSkillType.get().getSkillTypeId());
        assertNotNull(optSkillType.get().getSkills());
        assertNotNull(optSkillType.get().getSkillTypeName());

        assertEquals(optSkillType.get().getSkillTypeName(), skillTypeName);
    }

    @Test
    void createSkillTypeTest(){
        Integer skillTypeId = TestData.genericId;

        SkillTypeEntity skillType = MaxEntityData.maxCreateSkillTypeEntity();
        CSkillTypeDto skillTypeDto = CDtoTestData.createSkillTypeDto();

        SkillTypeEntity skillTypeToSaved = skillType;
        skillTypeToSaved.setSkillTypeId(skillTypeId);

        Mockito.when(skillTypeRepository.save(skillType))
                .thenReturn(skillTypeToSaved);

        SkillTypeEntity savedSkill = skillTypeRepository.save(skillType);

        assertEquals(skillTypeDto.getSkillTypeNameDto(), savedSkill.getSkillTypeName());

        assertNotNull(savedSkill);
        assertNotNull(savedSkill.getSkillTypeId());
        assertNotNull(savedSkill.getSkills());
        assertNotNull(savedSkill.getSkillTypeName());

    }
}
