package com.DIGIPEDIA.Digimon.Collection.dao;

import com.DIGIPEDIA.Digimon.Collection.TestData.Dto.CDtoTestData;
import com.DIGIPEDIA.Digimon.Collection.TestData.Entity.MaxEntityData;
import com.DIGIPEDIA.Digimon.Collection.TestData.TestData;
import com.DIGIPEDIA.Digimon.Collection.dao.daoImpl.SkillTypeDaoImpl;
import com.DIGIPEDIA.Digimon.Collection.dto.skillTypeDto.CSkillTypeDto;
import com.DIGIPEDIA.Digimon.Collection.entities.SkillTypeEntity;
import com.DIGIPEDIA.Digimon.Collection.repositories.SkillTypeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class SkillTypeDaoTest {

    @Mock
    private SkillTypeRepository skillTypeRepository;


    @InjectMocks
    private SkillTypeDaoImpl skillTypeDao;

    @Test
    void findSkillTypeById() throws IOException {
        Integer skillTypeId = TestData.genericId;

        SkillTypeEntity skillType = MaxEntityData.maxCreateSkillTypeEntity();
        skillType.setSkillTypeId(skillTypeId);

        Mockito.when(skillTypeRepository.findBySkillTypeId(skillTypeId))
                .thenReturn(Optional.of(skillType));

        SkillTypeEntity skillTypeRes = skillTypeDao.findSkillTypeByIdDao(skillTypeId);

        assertEquals(skillTypeId, skillTypeRes.getSkillTypeId());

        assertNotNull(skillTypeRes);
        assertNotNull(skillTypeRes.getSkillTypeId());
        assertNotNull(skillTypeRes.getSkills());
        assertNotNull(skillTypeRes.getSkillTypeName());
    }

    @Test
    void findSkillTypeByName() throws IOException {
        Integer skillTypeId = TestData.genericId;
        String skillTypeName = TestData.skillTypeName;

        SkillTypeEntity skillType = MaxEntityData.maxCreateSkillTypeEntity();
        skillType.setSkillTypeId(skillTypeId);

        Mockito.when(skillTypeRepository.findBySkillTypeName(skillTypeName))
                .thenReturn(Optional.of(skillType));

        SkillTypeEntity skillTypeRes = skillTypeDao.findSkillTypeByNameDao(skillTypeName);

        assertEquals(skillTypeName, skillTypeRes.getSkillTypeName());

        assertNotNull(skillTypeRes);
        assertNotNull(skillTypeRes.getSkillTypeId());
        assertNotNull(skillTypeRes.getSkills());
        assertNotNull(skillTypeRes.getSkillTypeName());
    }

    @Test
    void findAllSkillType() throws IOException {
        Integer skillTypeId = TestData.genericId;

        SkillTypeEntity skillTypeEntity = MaxEntityData.maxCreateSkillTypeEntity();
        skillTypeEntity.setSkillTypeId(skillTypeId);

        List<SkillTypeEntity> skillTypeList = new ArrayList<>();

        skillTypeList.add(skillTypeEntity);
        skillTypeList.add(skillTypeEntity);
        skillTypeList.add(skillTypeEntity);

        Mockito.when(skillTypeRepository.findAll())
                .thenReturn(skillTypeList);

        List<SkillTypeEntity> skillTypeListRes = skillTypeDao.findAllSkillTypesDao();

        assertNotNull(skillTypeListRes);

        skillTypeListRes.forEach(skillType ->{
            assertNotNull(skillType);
            assertNotNull(skillType.getSkillTypeId());
            assertNotNull(skillType.getSkills());
            assertNotNull(skillType.getSkillTypeName());
        });
    }

    @Test
    void createSkilTypeDaoTest() throws IOException {
        Integer skillTypeId = TestData.genericId;

        SkillTypeEntity skillTypeEntity = MaxEntityData.maxCreateSkillTypeEntity();
        skillTypeEntity.setSkillTypeId(skillTypeId);

        CSkillTypeDto skillTypeDto = CDtoTestData.createSkillTypeDto();

        Mockito.when(skillTypeRepository.save(Mockito.any()))
                .thenReturn(skillTypeEntity);

        skillTypeDao.createSkillTypeDao(skillTypeDto);

        Mockito.verify(skillTypeRepository , Mockito.times(1)).save(Mockito.any());
    }

}
