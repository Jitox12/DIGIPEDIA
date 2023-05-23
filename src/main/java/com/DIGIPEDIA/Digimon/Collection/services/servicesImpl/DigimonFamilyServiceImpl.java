package com.DIGIPEDIA.Digimon.Collection.services.servicesImpl;

import com.DIGIPEDIA.Digimon.Collection.dao.DigimonFamilyDao;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonFamilyDto.CDigimonFamilyDto;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonFamilyDto.GADigimonFamilyDto;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonFamilyDto.GDigimonFamilyDto;
import com.DIGIPEDIA.Digimon.Collection.entities.DigimonFamilyEntity;
import com.DIGIPEDIA.Digimon.Collection.exceptions.BadRequestException;
import com.DIGIPEDIA.Digimon.Collection.mappers.DigimonFamilyMapper;
import com.DIGIPEDIA.Digimon.Collection.services.DigimonFamilyService;
import com.DIGIPEDIA.Digimon.Collection.utils.FormatUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class DigimonFamilyServiceImpl implements DigimonFamilyService {
    private final DigimonFamilyDao digimonFamilyDao;
    private final DigimonFamilyMapper digimonFamilyMapper;

    public DigimonFamilyServiceImpl(DigimonFamilyDao digimonFamilyDao, DigimonFamilyMapper digimonFamilyMapper) {
        this.digimonFamilyDao = digimonFamilyDao;
        this.digimonFamilyMapper = digimonFamilyMapper;
    }

    @Override
    public void createDigimonFamily(CDigimonFamilyDto cDigimonFamilyDto) {
        if(Objects.isNull(cDigimonFamilyDto)){
            throw new BadRequestException("CDigimonFamilyDto  is null");
        }
        String upperCaseDigimonFamilyName = FormatUtils.UpperCase(cDigimonFamilyDto.getDigimonFamilyNameDto());
        cDigimonFamilyDto.setDigimonFamilyNameDto(upperCaseDigimonFamilyName);

        try {
            digimonFamilyDao.createDigimonFamilyDao(cDigimonFamilyDto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public GADigimonFamilyDto findDigimonFamilyById(Integer digimonFamilyId) {
        try {
            DigimonFamilyEntity digimonFamily;
            GADigimonFamilyDto digimonFamilyDto;
            digimonFamily = digimonFamilyDao.findDigimonFamilyByIdDao(digimonFamilyId);
            digimonFamilyDto = digimonFamilyMapper.digimonTypetoGADigimonTypeDto(digimonFamily);

            return digimonFamilyDto;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public GADigimonFamilyDto findDigimonFamilyByName(String digimonFamilyName) {
        try {
            DigimonFamilyEntity digimonFamily;
            GADigimonFamilyDto digimonFamilyDto;
            digimonFamily = digimonFamilyDao.findDigimonFamilyByNameDao(digimonFamilyName);
            digimonFamilyDto = digimonFamilyMapper.digimonTypetoGADigimonTypeDto(digimonFamily);

            return digimonFamilyDto;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<GDigimonFamilyDto> findAllDigimonFamily() {
        try {
            List<DigimonFamilyEntity> digimonFamilyList;
            List<GDigimonFamilyDto> digimonFamilyDtoList;

            digimonFamilyList = digimonFamilyDao.findAllDigimonFamilyDao();

            digimonFamilyDtoList = digimonFamilyList.stream()
                    .map(digimonFamilyMapper::digimonTypetoGDigimonTypeDto)
                    .collect(Collectors.toList());

            return digimonFamilyDtoList;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
