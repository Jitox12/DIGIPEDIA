package com.DIGIPEDIA.Digimon.Collection.dao;

public interface EvolutionDao {

    public void evolveDigimon(Integer digimonId, Integer digimonEvolveId);

    public boolean verifyEvolve(Integer digimonId, Integer digimonEvolveId);
}
