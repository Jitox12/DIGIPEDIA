package com.DIGIPEDIA.Digimon.Collection.services.servicesImpl;

import com.DIGIPEDIA.Digimon.Collection.dao.DigimonTypeDao;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonTypeDto.CDigimonTypeDto;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonTypeDto.GADigimonTypeDto;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonTypeDto.GDigimonTypeDto;
import com.DIGIPEDIA.Digimon.Collection.entities.DigimonTypeEntity;
import com.DIGIPEDIA.Digimon.Collection.exceptions.BadRequestException;
import com.DIGIPEDIA.Digimon.Collection.mappers.DigimonTypeMapper;
import com.DIGIPEDIA.Digimon.Collection.services.DigimonTypeService;
import com.DIGIPEDIA.Digimon.Collection.utils.FormatUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class DigimonTypeServiceImpl implements DigimonTypeService {

    private final DigimonTypeDao digimonTypeDao;
    private final DigimonTypeMapper digimonTypeMapper;

    public DigimonTypeServiceImpl(DigimonTypeDao digimonTypeDao, DigimonTypeMapper digimonTypeMapper) {
        this.digimonTypeDao = digimonTypeDao;
        this.digimonTypeMapper = digimonTypeMapper;
    }

    @Override
    public void createDigimonType(CDigimonTypeDto digimonTypeDto) {

        if(Objects.isNull(digimonTypeDto)){
            throw new BadRequestException("CDigimonFamilyDto  is null");
        }
        String upperCaseDigimonTypeName = FormatUtils.UpperCase(digimonTypeDto.getDigimonTypeNameDto());
        digimonTypeDto.setDigimonTypeNameDto(upperCaseDigimonTypeName);


        try{
            digimonTypeDao.createDigimonTypeDao(digimonTypeDto);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public GADigimonTypeDto findDigimonTypeById(Integer digimonTypeId) {
        try{
            GADigimonTypeDto digimonTypeDto;
            DigimonTypeEntity digimonType;

            digimonType = digimonTypeDao.findDigimonTypeByIdDao(digimonTypeId);
            digimonTypeDto = digimonTypeMapper.digimonTypeEntityToGADigimonTypeDto(digimonType);

            return digimonTypeDto;

        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public GADigimonTypeDto findDigimonTypeByName(String digimonTypeName) {
        try{
            GADigimonTypeDto digimonTypeDto;
            DigimonTypeEntity digimonType;

            digimonType = digimonTypeDao.findDigimonTypeByNameDao(digimonTypeName);
            digimonTypeDto = digimonTypeMapper.digimonTypeEntityToGADigimonTypeDto(digimonType);

            return digimonTypeDto;

        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<GDigimonTypeDto> findAllDigimonTypes() {
        try{
            List<GDigimonTypeDto> digimonTypeDtoList;
            List<DigimonTypeEntity> digimonTypeList;

            digimonTypeList = digimonTypeDao.findAllDigimonTypeDao();
            digimonTypeDtoList = digimonTypeList.stream()
                    .map(digimonTypeMapper::digimonTypeEntityToGDigimonTypeDto).collect(Collectors.toList());

            return digimonTypeDtoList;

        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
