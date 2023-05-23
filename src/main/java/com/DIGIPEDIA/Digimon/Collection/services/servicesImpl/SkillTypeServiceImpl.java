package com.DIGIPEDIA.Digimon.Collection.services.servicesImpl;

import com.DIGIPEDIA.Digimon.Collection.dao.SkillTypeDao;
import com.DIGIPEDIA.Digimon.Collection.dto.skillTypeDto.CSkillTypeDto;
import com.DIGIPEDIA.Digimon.Collection.dto.skillTypeDto.GASkillTypeDto;
import com.DIGIPEDIA.Digimon.Collection.dto.skillTypeDto.GSkillTypeDto;
import com.DIGIPEDIA.Digimon.Collection.entities.SkillTypeEntity;
import com.DIGIPEDIA.Digimon.Collection.exceptions.BadRequestException;
import com.DIGIPEDIA.Digimon.Collection.mappers.SkillTypeMapper;
import com.DIGIPEDIA.Digimon.Collection.services.SkillTypeService;
import com.DIGIPEDIA.Digimon.Collection.utils.FormatUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class SkillTypeServiceImpl implements SkillTypeService {

    private final SkillTypeDao skillTypeDao;
    private final SkillTypeMapper skillTypeMapper;

    public SkillTypeServiceImpl(SkillTypeDao skillTypeDao, SkillTypeMapper skillTypeMapper) {
        this.skillTypeDao = skillTypeDao;
        this.skillTypeMapper = skillTypeMapper;
    }

    @Override
    public void createSkillType(CSkillTypeDto skillTypeDto) {

        if(Objects.isNull(skillTypeDto)){
            throw new BadRequestException("CDigimonFamilyDto  is null");
        }
        String upperCaseSkillName = FormatUtils.UpperCase(skillTypeDto.getSkillTypeNameDto());
        skillTypeDto.setSkillTypeNameDto(upperCaseSkillName);

        try{
            skillTypeDao.createSkillTypeDao(skillTypeDto);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public GASkillTypeDto findSkillTypeById(Integer skillTypeId) {
        try{
            SkillTypeEntity skillType;
            GASkillTypeDto skillTypeDto;

            skillType = skillTypeDao.findSkillTypeByIdDao(skillTypeId);
            skillTypeDto = skillTypeMapper.skillTypeEntityToGASkillTypeDto(skillType);

            return skillTypeDto;
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public GASkillTypeDto findSkillTypeByName(String skillTypeName) {
        try{
            SkillTypeEntity skillType;
            GASkillTypeDto skillTypeDto;

            skillType = skillTypeDao.findSkillTypeByNameDao(skillTypeName);
            skillTypeDto = skillTypeMapper.skillTypeEntityToGASkillTypeDto(skillType);

            return skillTypeDto;
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<GSkillTypeDto> findAllSkillTypes() {
        try{
            List<GSkillTypeDto> skillTypeDtoList;
            List<SkillTypeEntity> skillTypeList;
            skillTypeList = skillTypeDao.findAllSkillTypesDao();
            skillTypeDtoList = skillTypeList.stream().map(skillTypeMapper::skillTypeEntityToGSkillTypeDto).collect(Collectors.toList());

            return skillTypeDtoList;
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
