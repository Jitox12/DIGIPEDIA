package com.DIGIPEDIA.Digimon.Collection.services.servicesImpl;

import com.DIGIPEDIA.Digimon.Collection.dao.EvolutionDao;
import com.DIGIPEDIA.Digimon.Collection.services.EvolutionService;
import org.springframework.stereotype.Service;

@Service
public class EvolutionServiceImpl implements EvolutionService {

    private final EvolutionDao evolutionDao;

    public EvolutionServiceImpl(EvolutionDao evolutionDao) {
        this.evolutionDao = evolutionDao;
    }


    @Override
    public void evolveDigimonService(Integer digimonId, Integer digimonEvolve) {

    }
}
