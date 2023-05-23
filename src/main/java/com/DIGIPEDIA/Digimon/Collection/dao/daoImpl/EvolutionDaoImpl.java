package com.DIGIPEDIA.Digimon.Collection.dao.daoImpl;

import com.DIGIPEDIA.Digimon.Collection.dao.DigimonDao;
import com.DIGIPEDIA.Digimon.Collection.dao.EvolutionDao;
import com.DIGIPEDIA.Digimon.Collection.entities.DigimonEntity;
import com.DIGIPEDIA.Digimon.Collection.entities.EvolutionEntity;
import com.DIGIPEDIA.Digimon.Collection.repositories.EvolutionRepository;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class EvolutionDaoImpl implements EvolutionDao {

    private final EvolutionRepository evolutionRepository;
    private final DigimonDao digimonDao;

    public EvolutionDaoImpl(EvolutionRepository evolutionRepository, DigimonDao digimonDao) {
        this.evolutionRepository = evolutionRepository;
        this.digimonDao = digimonDao;
    }

    @Override
    public void evolveDigimon(Integer digimonId, Integer digimonEvolveId) {

        EvolutionEntity evolution = EvolutionEntity.builder()
                .digimonId(digimonId)
                .digimonEvolvedId(digimonEvolveId).build();

        evolutionRepository.save(evolution);
    }

    @Override
    public boolean verifyEvolve(Integer digimonId, Integer digimonEvolveId) {
        boolean evoVerify = evolutionRepository.noRepeatEvolve(digimonId,digimonEvolveId);;
        return evoVerify;
    }


}
