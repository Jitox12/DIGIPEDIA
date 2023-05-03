package com.DIGIPEDIA.Digimon.Collection.services;


import com.DIGIPEDIA.Digimon.Collection.dto.skillDto.CSkillDto;
import com.DIGIPEDIA.Digimon.Collection.dto.skillDto.GASkillDto;
import com.DIGIPEDIA.Digimon.Collection.dto.skillDto.GSkillDto;

import java.util.List;

public interface SkillService {

    public void createSkill(CSkillDto skillDto);
    public GASkillDto findSkillById(Integer skillId);
    public GASkillDto findSkillByName(String skillName);
    public List<GSkillDto> findAllSkills();
}
