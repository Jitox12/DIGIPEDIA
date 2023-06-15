package com.DIGIPEDIA.Digimon.Collection.controllers;

import com.DIGIPEDIA.Digimon.Collection.dto.evolutionDto.CEvolutionDto;
import com.DIGIPEDIA.Digimon.Collection.services.EvolutionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/evolution")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})

public class EvolutionController {

    private final EvolutionService evolutionService;

    public EvolutionController(EvolutionService evolutionService) {
        this.evolutionService = evolutionService;
    }


    @PostMapping(value = "/evolve")
    public ResponseEntity<String> evolveDigimonController(@RequestBody CEvolutionDto evolutionDto) {

        evolutionService.evolveDigimonService(evolutionDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("EVOLUTION E INVOLUTION CREATED");
    }
}
