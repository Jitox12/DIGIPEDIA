package com.DIGIPEDIA.Digimon.Collection.dao;

import com.DIGIPEDIA.Digimon.Collection.dto.evolutionDto.CEvolutionDto;

public interface EvoInvoDao {

    public void EvoDao(CEvolutionDto evolutionDto);

    public void InvoDao(Integer digimonId, Integer digimonInvoId);
}
