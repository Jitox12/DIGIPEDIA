package com.DIGIPEDIA.Digimon.Collection.services.servicesImpl;

import com.DIGIPEDIA.Digimon.Collection.dao.DigimonTypeAttributeDao;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonTypeAttributeDto.CDigimonTypeAttributeDto;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonTypeAttributeDto.GADigimonTypeAttributeDto;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonTypeAttributeDto.GDigimonTypeAttributeDto;
import com.DIGIPEDIA.Digimon.Collection.entities.DigimonTypeAttributeEntity;
import com.DIGIPEDIA.Digimon.Collection.mappers.DigimonTypeAttributeMapper;
import com.DIGIPEDIA.Digimon.Collection.services.DigimonTypeAttributeService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class DigimonTypeAttributeServiceImpl implements DigimonTypeAttributeService {


    private final DigimonTypeAttributeDao digimonTypeAttributeDao;
    private final DigimonTypeAttributeMapper digimonTypeAttributeMapper;

    public DigimonTypeAttributeServiceImpl(DigimonTypeAttributeDao digimonTypeAttributeDao, DigimonTypeAttributeMapper digimonTypeAttributeMapper) {
        this.digimonTypeAttributeDao = digimonTypeAttributeDao;
        this.digimonTypeAttributeMapper = digimonTypeAttributeMapper;
    }

    @Override
    public void createDigimonTypeAttribute(CDigimonTypeAttributeDto digimonTypeAttributeDto) {
        try{
            digimonTypeAttributeDao.createSkillDao(digimonTypeAttributeDto);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public GADigimonTypeAttributeDto findDigimonTypeAttributeById(Integer digimonTypeAttributeId) {
        try {
            GADigimonTypeAttributeDto digimonTypeAttributeDto;
            DigimonTypeAttributeEntity digimonTypeAttributeEntity;
            digimonTypeAttributeEntity = digimonTypeAttributeDao.findDigimonTypeAttributeByIdDao(digimonTypeAttributeId);
            digimonTypeAttributeDto = digimonTypeAttributeMapper.digimonTypeAttributeEntityToGADigimonTypeAttributeDto(digimonTypeAttributeEntity);

            return digimonTypeAttributeDto;
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public GADigimonTypeAttributeDto findDigimonTypeAttributeByName(String digimonTypeAttributeName) {
        try {
            GADigimonTypeAttributeDto digimonTypeAttributeDto;
            DigimonTypeAttributeEntity digimonTypeAttributeEntity;
            digimonTypeAttributeEntity = digimonTypeAttributeDao.findDigimonTypeAttributeByNameDao(digimonTypeAttributeName);
            digimonTypeAttributeDto = digimonTypeAttributeMapper.digimonTypeAttributeEntityToGADigimonTypeAttributeDto(digimonTypeAttributeEntity);

            return digimonTypeAttributeDto;
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<GDigimonTypeAttributeDto> findAllDigimonTypeAttribute() {
       try{
           List<GDigimonTypeAttributeDto> digimonTypeAttributeDtoList;
           List<DigimonTypeAttributeEntity> digimonTypeAttributeList;

           digimonTypeAttributeList = digimonTypeAttributeDao.findAllDigimonTypeAttributeDao();
           digimonTypeAttributeDtoList = digimonTypeAttributeList
                   .stream()
                   .map(digimonTypeAttributeMapper::digimonTypeAttributeEntityToGDigimonTypeAttributeDto).collect(Collectors.toList());

           return digimonTypeAttributeDtoList;
       }catch (IOException e){
           throw new RuntimeException(e);
       }
    }
}
