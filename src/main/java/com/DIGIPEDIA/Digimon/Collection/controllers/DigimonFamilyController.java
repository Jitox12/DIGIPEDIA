package com.DIGIPEDIA.Digimon.Collection.controllers;

import com.DIGIPEDIA.Digimon.Collection.dto.digimonFamilyDto.CDigimonFamilyDto;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonFamilyDto.GADigimonFamilyDto;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonFamilyDto.GDigimonFamilyDto;
import com.DIGIPEDIA.Digimon.Collection.services.DigimonFamilyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/digimonfamily")
public class DigimonFamilyController {

    private final DigimonFamilyService digimonFamilyService;

    public DigimonFamilyController(DigimonFamilyService digimonFamilyService) {
        this.digimonFamilyService = digimonFamilyService;
    }

    @GetMapping(value = "/findbyid/{digimonFamilyId}")
    public GADigimonFamilyDto findDigimonFamilyByIdController(@PathVariable Integer digimonFamilyId) {
        GADigimonFamilyDto gaDigimonFamilyDto;

        gaDigimonFamilyDto = digimonFamilyService.findDigimonFamilyById(digimonFamilyId);

        return gaDigimonFamilyDto;
    }
    @GetMapping(value = "/findbyname/{digimonFamilyName}")
    public GADigimonFamilyDto findDigimonFamilyByNameController(@PathVariable String digimonFamilyName){
        GADigimonFamilyDto gaDigimonFamilyDto;

        gaDigimonFamilyDto = digimonFamilyService.findDigimonFamilyByName(digimonFamilyName);

        return  gaDigimonFamilyDto;
    }
    @GetMapping(value = "/findall")
    public List<GDigimonFamilyDto> findAllDigimonFamily(){
        List<GDigimonFamilyDto> digimonFamilyDtoList;
        digimonFamilyDtoList = digimonFamilyService.findAllDigimonFamily();

        return digimonFamilyDtoList;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<String> createDigimonFamilyController(@RequestBody CDigimonFamilyDto cDigimonFamilyDto){
        digimonFamilyService.createDigimonFamily(cDigimonFamilyDto);

        return ResponseEntity.status(HttpStatus.CREATED).body("DIGIMON FAMILY CREATED");
    }

}