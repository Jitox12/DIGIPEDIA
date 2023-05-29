package com.DIGIPEDIA.Digimon.Collection.dao;

import java.io.IOException;

public interface InvolutionDao {

    public void involveDigimon(Integer digimonId, Integer digimonInvolveId) throws IOException;

    public boolean verifyInvolve(Integer digimonId, Integer digimonInvolveId) throws IOException;
}
