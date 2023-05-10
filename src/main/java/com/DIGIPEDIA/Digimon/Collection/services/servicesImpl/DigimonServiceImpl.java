package com.DIGIPEDIA.Digimon.Collection.services.servicesImpl;

import com.DIGIPEDIA.Digimon.Collection.dao.DigimonDao;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonDto.CDigimonDto;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonDto.GADigimonDto;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonDto.GDigimonDto;
import com.DIGIPEDIA.Digimon.Collection.entities.DigimonEntity;
import com.DIGIPEDIA.Digimon.Collection.mappers.DigimonMapper;
import com.DIGIPEDIA.Digimon.Collection.services.DigimonService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DigimonServiceImpl implements DigimonService {

    private final DigimonDao digimonDao;
    private final DigimonMapper digimonMapper;

    public DigimonServiceImpl(DigimonDao digimonDao, DigimonMapper digimonMapper) {
        this.digimonDao = digimonDao;
        this.digimonMapper = digimonMapper;
    }

    @Override
    public void createDigimon(CDigimonDto cDigimonDto) {
        try{
            digimonDao.createDigimonDao(cDigimonDto);
        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public GADigimonDto findDigimonById(Integer digimonId) {
        try{
            GADigimonDto digimonDto;
            DigimonEntity digimon;

            digimon = digimonDao.findDigimonByIdDao(digimonId);
            digimonDto = digimonMapper.digimontoGADigimonDto(digimon);

            return digimonDto;
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public GADigimonDto findDigimonByName(String digimonName) {
        try{
            GADigimonDto digimonDto;
            DigimonEntity digimon;

            digimon = digimonDao.findDigimonByNameDao(digimonName);
            digimonDto = digimonMapper.digimontoGADigimonDto(digimon);

            return digimonDto;
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<GDigimonDto> findAllDigimon() {
        try{
            List<GDigimonDto> digimonDtoList;
            List<DigimonEntity> digimonList;

            digimonList = digimonDao.findAllDigimonDao();
            digimonDtoList = digimonList.stream().map(digimonMapper::digimontoGDigimonDto).collect(Collectors.toList());

            return digimonDtoList;
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}