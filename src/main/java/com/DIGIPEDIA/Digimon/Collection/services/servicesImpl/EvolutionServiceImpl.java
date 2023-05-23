package com.DIGIPEDIA.Digimon.Collection.services.servicesImpl;

import com.DIGIPEDIA.Digimon.Collection.dao.DigimonDao;
import com.DIGIPEDIA.Digimon.Collection.dao.EvolutionDao;
import com.DIGIPEDIA.Digimon.Collection.dto.evolutionDto.CEvolutionDto;
import com.DIGIPEDIA.Digimon.Collection.entities.DigimonEntity;
import com.DIGIPEDIA.Digimon.Collection.services.EvolutionService;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EvolutionServiceImpl implements EvolutionService {

    private final EvolutionDao evolutionDao;
    private final DigimonDao digimonDao;

    public EvolutionServiceImpl(EvolutionDao evolutionDao, DigimonDao digimonDao) {
        this.evolutionDao = evolutionDao;
        this.digimonDao = digimonDao;
    }


    @Override
    public void evolveDigimonService(CEvolutionDto evolutionDto) {
        try{
            DigimonEntity digimon = digimonDao.findDigimonByIdDao(evolutionDto.getDigimonId());
            DigimonEntity evolvedDigimon = digimonDao.findDigimonByIdDao(evolutionDto.getDigimonEvolvedId());


        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
