package com.DIGIPEDIA.Digimon.Collection.services.servicesImpl;

import com.DIGIPEDIA.Digimon.Collection.dao.DigimonFamilyDao;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonFamilyDto.CDigimonFamilyDto;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonFamilyDto.GADigimonFamilyDto;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonFamilyDto.GDigimonFamilyDto;
import com.DIGIPEDIA.Digimon.Collection.entities.DigimonFamilyEntity;
import com.DIGIPEDIA.Digimon.Collection.mappers.DigimonFamilyMapper;
import com.DIGIPEDIA.Digimon.Collection.services.DigimonFamilyService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

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
        try {
            digimonFamilyDao.createDigimonFamilyDao(cDigimonFamilyDto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public GADigimonFamilyDto findDigimonFamilyById(Integer digimonFamilyId) {
        try{
            DigimonFamilyEntity digimonFamily;
            GADigimonFamilyDto digimonFamilyDto;
            digimonFamily = digimonFamilyDao.findDigimonFamilyByIdDao(digimonFamilyId);
            digimonFamilyDto = digimonFamilyMapper.digimonTypetoGADigimonTypeDto(digimonFamily);

            return digimonFamilyDto;

        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public GADigimonFamilyDto findDigimonFamilyByName(String digimonFamilyName) {
        return null;
    }

    @Override
    public List<GDigimonFamilyDto> findAllDigimonFamily() {
        return null;
    }
}