package com.DIGIPEDIA.Digimon.Collection.dao.daoImpl;

import com.DIGIPEDIA.Digimon.Collection.dao.EvolutionDao;
import com.DIGIPEDIA.Digimon.Collection.entities.EvolutionEntity;
import com.DIGIPEDIA.Digimon.Collection.repositories.EvolutionRepository;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class EvolutionDaoImpl implements EvolutionDao {

    private final EvolutionRepository evolutionRepository;

    public EvolutionDaoImpl(EvolutionRepository evolutionRepository) {
        this.evolutionRepository = evolutionRepository;
    }
    @Override
    @Transactional
    public void evolveDigimon(Integer digimonId) {
    }

    @Override
    public boolean verifyEvolve(Integer digimonId, Integer digimonEvolveId) {
        return true;
    }


}
