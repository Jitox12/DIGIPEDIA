package com.DIGIPEDIA.Digimon.Collection.dao;

public interface InvolutionDao {

    public void involveDigimon(Integer digimonId, Integer digimonInvolveId);

    public boolean verifyInvolve(Integer digimonId, Integer digimonInvolveId);
}
