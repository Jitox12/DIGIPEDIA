package com.DIGIPEDIA.Digimon.Collection.controllers;

import com.DIGIPEDIA.Digimon.Collection.dao.EvolutionDao;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonTypeDto.CDigimonTypeDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/evolution")
public class EvolutionController {

    private final EvolutionDao evolutionDao;

    public EvolutionController(EvolutionDao evolutionDao) {
        this.evolutionDao = evolutionDao;
    }

    @PostMapping(value = "/evolve")
    public void evolveDigimonController(@RequestBody CDigimonTypeDto digimon) {
        evolutionDao.evolveDigimon(6);

    }
}
