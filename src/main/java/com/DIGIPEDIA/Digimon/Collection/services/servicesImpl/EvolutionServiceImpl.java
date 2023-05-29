package com.DIGIPEDIA.Digimon.Collection.services.servicesImpl;

import com.DIGIPEDIA.Digimon.Collection.dao.DigimonDao;
import com.DIGIPEDIA.Digimon.Collection.dao.EvoInvoDao;
import com.DIGIPEDIA.Digimon.Collection.dto.evolutionDto.CEvolutionDto;
import com.DIGIPEDIA.Digimon.Collection.entities.DigimonEntity;
import com.DIGIPEDIA.Digimon.Collection.exceptions.EvolveException;
import com.DIGIPEDIA.Digimon.Collection.services.EvolutionService;
import com.DIGIPEDIA.Digimon.Collection.utils.FamilyCatcher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;

@Service
public class EvolutionServiceImpl implements EvolutionService {

    private final EvoInvoDao evoInvoDao;
    private final DigimonDao digimonDao;

    public EvolutionServiceImpl(EvoInvoDao evoInvoDao, DigimonDao digimonDao) {
        this.evoInvoDao = evoInvoDao;
        this.digimonDao = digimonDao;
    }

    @Transactional
    @Override
    public void evolveDigimonService(CEvolutionDto evolutionDto) {
        try{
            DigimonEntity digimon = digimonDao.findDigimonByIdDao(evolutionDto.getDigimonIdDto());
            DigimonEntity evolvedDigimon = digimonDao.findDigimonByIdDao(evolutionDto.getDigimonEvolvedIdDto());

          boolean familyResponse =  FamilyCatcher.familyEvolvedCatcher(digimon.getDigimon_family().getDigimonFamilyName(),evolvedDigimon.getDigimon_family().getDigimonFamilyName());

          if(!familyResponse){
            throw new EvolveException("it is necessary to a superior family to evolve");
          }

          evoInvoDao.EvoDao(evolutionDto);

        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
