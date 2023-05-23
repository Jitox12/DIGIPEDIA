package com.DIGIPEDIA.Digimon.Collection.services;

import com.DIGIPEDIA.Digimon.Collection.dto.evolutionDto.CEvolutionDto;
import com.DIGIPEDIA.Digimon.Collection.entities.EvolutionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvolutionService {

    public void evolveDigimonService(CEvolutionDto evolutionDto);
}
