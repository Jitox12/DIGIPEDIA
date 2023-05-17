package com.DIGIPEDIA.Digimon.Collection.dao;

public interface EvolutionDao {

    public void evolveDigimon(Integer id);

    public boolean verifyEvolve(Integer digimonId, Integer digimonEvolveId);
}
