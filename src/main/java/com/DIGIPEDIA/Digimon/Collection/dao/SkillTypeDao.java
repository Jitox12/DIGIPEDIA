package com.DIGIPEDIA.Digimon.Collection.dao;

import com.DIGIPEDIA.Digimon.Collection.dto.skillTypeDto.CSkillTypeDto;
import com.DIGIPEDIA.Digimon.Collection.entities.SkillTypeEntity;

import java.io.IOException;
import java.util.List;

public interface SkillTypeDao {

    public void createSkillTypeDao(CSkillTypeDto skillTypeDto) throws IOException;
    public List<SkillTypeEntity> findAllSkillTypesDao() throws IOException;
    public SkillTypeEntity findSkillTypeByIdDao(Integer skillTypeId) throws IOException;
    public SkillTypeEntity findSkillTypeByNameDao(String skillTypeName) throws IOException;
}
