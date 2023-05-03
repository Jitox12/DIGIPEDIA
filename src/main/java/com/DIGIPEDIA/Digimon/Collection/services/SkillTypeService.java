package com.DIGIPEDIA.Digimon.Collection.services;


import com.DIGIPEDIA.Digimon.Collection.dto.skillTypeDto.CSkillTypeDto;
import com.DIGIPEDIA.Digimon.Collection.dto.skillTypeDto.GASkillTypeDto;
import com.DIGIPEDIA.Digimon.Collection.dto.skillTypeDto.GSkillTypeDto;

import java.util.List;

public interface SkillTypeService {
    public void createSkillType(CSkillTypeDto skillTypeDto);
    public GASkillTypeDto findSkillTypeById(Integer skillTypeId);
    public GASkillTypeDto findSkillTypeByName(String skillTypeName);
    public List<GSkillTypeDto> findAllSkillTypes();
}
