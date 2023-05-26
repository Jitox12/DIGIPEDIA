package com.DIGIPEDIA.Digimon.Collection.dao.daoImpl;

import com.DIGIPEDIA.Digimon.Collection.dao.SkillDao;
import com.DIGIPEDIA.Digimon.Collection.dto.skillDto.CSkillDto;
import com.DIGIPEDIA.Digimon.Collection.entities.SkillEntity;
import com.DIGIPEDIA.Digimon.Collection.exceptions.BadRequestException;
import com.DIGIPEDIA.Digimon.Collection.repositories.SkillRepository;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
@Component
public class SkillDaoImpl implements SkillDao {

    private final SkillRepository skillRepository;

    public SkillDaoImpl(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Override
    public void createSkillDao(CSkillDto skillDto) throws IOException {
        SkillEntity skill = SkillEntity.builder()
                .skillName(skillDto.getSkillNameDto())
                .skillDescription(skillDto.getSkillDescriptionDto())
                .skillTypeId(skillDto.getSkillTypeIdDto())
                .attributeId(skillDto.getAttributeIdDto())
                .build();

        skillRepository.save(skill);
    }

    @Override
    public List<SkillEntity> findAllSkillsDao() throws IOException {
        List<SkillEntity> skillList;
        skillList = skillRepository.findAll();

        return skillList;
    }

    @Override
    @Transactional
    public SkillEntity findSkillByIdDao(Integer skillId) throws IOException {
        SkillEntity skill;
        skill = skillRepository.findBySkillId(skillId)
                .orElseThrow(()-> new BadRequestException("Skill id: ".concat(String.valueOf(skillId))));
        return skill;
    }

    @Override
    @Transactional
    public SkillEntity findSkillByNameDao(String skillName) throws IOException {
        SkillEntity skill;
        skill = skillRepository.findBySkillName(skillName)
                .orElseThrow(()-> new BadRequestException("Skill Name: ".concat(skillName)));

        return skill;
    }
}
