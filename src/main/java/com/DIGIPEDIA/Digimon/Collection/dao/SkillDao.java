package com.DIGIPEDIA.Digimon.Collection.dao;

import com.DIGIPEDIA.Digimon.Collection.dto.skillDto.CSkillDto;
import com.DIGIPEDIA.Digimon.Collection.entities.SkillEntity;

import java.io.IOException;
import java.util.List;

public interface SkillDao {

    public void createSkillDao(CSkillDto skillDto) throws IOException;
    public List<SkillEntity> findAllSkillsDao() throws IOException;
    public SkillEntity findSkillByIdDao(Integer skillId) throws IOException;
    public SkillEntity findSkillByNameDao(String skillName) throws IOException;
}
