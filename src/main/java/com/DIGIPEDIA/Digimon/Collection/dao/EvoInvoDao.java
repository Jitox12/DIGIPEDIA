package com.DIGIPEDIA.Digimon.Collection.dao;

import com.DIGIPEDIA.Digimon.Collection.dto.evolutionDto.CEvolutionDto;
import com.DIGIPEDIA.Digimon.Collection.dto.involutionDto.CInvolutionDto;

import java.io.IOException;

public interface EvoInvoDao {

    public void EvoDao(CEvolutionDto evolutionDto) throws IOException;

    public void InvoDao(CInvolutionDto involutionDto) throws IOException;
}
