package com.DIGIPEDIA.Digimon.Collection.dao.daoImpl;

import com.DIGIPEDIA.Digimon.Collection.dao.SkillTypeDao;
import com.DIGIPEDIA.Digimon.Collection.dto.skillTypeDto.CSkillTypeDto;
import com.DIGIPEDIA.Digimon.Collection.entities.SkillTypeEntity;
import com.DIGIPEDIA.Digimon.Collection.exceptions.BadRequestException;
import com.DIGIPEDIA.Digimon.Collection.repositories.SkillTypeRepository;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@Component
public class SkillTypeDaoImpl implements SkillTypeDao {

    private final SkillTypeRepository skillTypeRepository;

    public SkillTypeDaoImpl(SkillTypeRepository skillTypeRepository) {
        this.skillTypeRepository = skillTypeRepository;
    }

    @Override
    @Transactional
    public void createSkillTypeDao(CSkillTypeDto skillTypeDto) throws IOException {
        SkillTypeEntity skillType = SkillTypeEntity.builder()
                .skillTypeName(skillTypeDto.getSkillTypeNameDto())
                .build();

        skillTypeRepository.save(skillType);
    }

    @Override
    @Transactional
    public List<SkillTypeEntity> findAllSkillTypesDao() throws IOException {
        List<SkillTypeEntity> skillTypeList;
        skillTypeList = skillTypeRepository.findAll();

        return skillTypeList;
    }

    @Override
    @Transactional
    public SkillTypeEntity findSkillTypeByIdDao(Integer skillTypeId) throws IOException {
        SkillTypeEntity skillType;
        skillType = skillTypeRepository.findBySkillTypeId(skillTypeId)
                .orElseThrow(()-> new BadRequestException("Skill Type id: ".concat(String.valueOf(skillTypeId))));

        return skillType;
    }

    @Override
    @Transactional
    public SkillTypeEntity findSkillTypeByNameDao(String skillTypeName) throws IOException {
        SkillTypeEntity skillType;
        skillType = skillTypeRepository.findBySkillTypeName(skillTypeName)
                .orElseThrow(()-> new BadRequestException("Skill Type name: ".concat(skillTypeName)));

        return skillType;
    }
}
