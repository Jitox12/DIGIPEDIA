package com.DIGIPEDIA.Digimon.Collection.controllers;

import com.DIGIPEDIA.Digimon.Collection.dto.digimonFamilyDto.GADigimonFamilyDto;
import com.DIGIPEDIA.Digimon.Collection.services.DigimonFamilyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/digimonfamily")
public class DigimonFamilyController {

    private final DigimonFamilyService digimonFamilyService;

    public DigimonFamilyController(DigimonFamilyService digimonFamilyService) {
        this.digimonFamilyService = digimonFamilyService;
    }

    @GetMapping(value = "findbyid/{digimonFamilyId}")
    public GADigimonFamilyDto findDigimonFamilyByIdController(@PathVariable Integer digimonFamilyId) {
        GADigimonFamilyDto gaDigimonFamilyDto;

        gaDigimonFamilyDto = digimonFamilyService.findDigimonFamilyById(digimonFamilyId);

        return gaDigimonFamilyDto;
    }
}