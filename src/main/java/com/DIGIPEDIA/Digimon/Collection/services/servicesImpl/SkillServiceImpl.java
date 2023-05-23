package com.DIGIPEDIA.Digimon.Collection.services.servicesImpl;

import com.DIGIPEDIA.Digimon.Collection.dao.SkillDao;
import com.DIGIPEDIA.Digimon.Collection.dto.skillDto.CSkillDto;
import com.DIGIPEDIA.Digimon.Collection.dto.skillDto.GASkillDto;
import com.DIGIPEDIA.Digimon.Collection.dto.skillDto.GSkillDto;
import com.DIGIPEDIA.Digimon.Collection.entities.SkillEntity;
import com.DIGIPEDIA.Digimon.Collection.exceptions.BadRequestException;
import com.DIGIPEDIA.Digimon.Collection.mappers.SkillMapper;
import com.DIGIPEDIA.Digimon.Collection.services.SkillService;
import com.DIGIPEDIA.Digimon.Collection.utils.FormatUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
@Service
public class SkillServiceImpl implements SkillService {

    private final SkillDao skillDao;
    private final SkillMapper skillMapper;

    public SkillServiceImpl(SkillDao skillDao, SkillMapper skillMapper) {
        this.skillDao = skillDao;
        this.skillMapper = skillMapper;
    }

    @Override
    public void createSkill(CSkillDto skillDto) {

        if(Objects.isNull(skillDto)){
            throw new BadRequestException("CDigimonFamilyDto  is null");
        }
        String upperCaseSkillName = FormatUtils.UpperCase(skillDto.getSkillNameDto());
        skillDto.setSkillNameDto(upperCaseSkillName);


        try {
            skillDao.createSkillDao(skillDto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public GASkillDto findSkillById(Integer skillId) {
        try {
            SkillEntity skill;
            GASkillDto skillDto;

            skill = skillDao.findSkillByIdDao(skillId);
            skillDto = skillMapper.skillEntityToGASkillDto(skill);

            return skillDto;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public GASkillDto findSkillByName(String skillName) {
        try {
            SkillEntity skill;
            GASkillDto skillDto;

            skill = skillDao.findSkillByNameDao(skillName);
            skillDto = skillMapper.skillEntityToGASkillDto(skill);

            return skillDto;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<GSkillDto> findAllSkills() {
        try {
            List<GSkillDto> skillDtoList;
            List<SkillEntity> skillList;
            skillList = skillDao.findAllSkillsDao();
            skillDtoList = skillList.stream().map(skillMapper::skillEntityToGSkillDto).collect(Collectors.toList());

            return skillDtoList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
