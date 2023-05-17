package com.DIGIPEDIA.Digimon.Collection.controllers;

import com.DIGIPEDIA.Digimon.Collection.dto.digimonTypeAttributeDto.CDigimonTypeAttributeDto;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonTypeAttributeDto.GADigimonTypeAttributeDto;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonTypeAttributeDto.GDigimonTypeAttributeDto;
import com.DIGIPEDIA.Digimon.Collection.services.DigimonTypeAttributeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/digimontypeattribute")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})

public class DigimonTypeAttributeController {
    private final DigimonTypeAttributeService digimonTypeAttributeService;

    public DigimonTypeAttributeController(DigimonTypeAttributeService digimonTypeAttributeService) {
        this.digimonTypeAttributeService = digimonTypeAttributeService;
    }

    @GetMapping(value = "/findbyid/{digimonTypeAttributeId}")
    public GADigimonTypeAttributeDto findDigimonTypeAttributeByIdController(@PathVariable Integer digimonTypeAttributeId) {
        GADigimonTypeAttributeDto digimonTypeAttributeDto;
        digimonTypeAttributeDto = digimonTypeAttributeService.findDigimonTypeAttributeById(digimonTypeAttributeId);

        return digimonTypeAttributeDto;
    }
    @GetMapping(value = "/findbyname/{digimonTypeAttributeName}")
    public GADigimonTypeAttributeDto findDigimonTypeAttributeByIdController(@PathVariable String digimonTypeAttributeName) {
        GADigimonTypeAttributeDto digimonTypeAttributeDto;
        digimonTypeAttributeDto = digimonTypeAttributeService.findDigimonTypeAttributeByName(digimonTypeAttributeName);

        return digimonTypeAttributeDto;
    }

    @GetMapping(value = "/findall")
    public List<GDigimonTypeAttributeDto> findAllDigimonTypeAttributeController() {
        List<GDigimonTypeAttributeDto> digimonTypeAttributeDtoList;
        digimonTypeAttributeDtoList = digimonTypeAttributeService.findAllDigimonTypeAttribute();

        return digimonTypeAttributeDtoList;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<String> createDigimonTypeAttributeController(@RequestBody  CDigimonTypeAttributeDto digimonTypeAttributeDto){
        digimonTypeAttributeService.createDigimonTypeAttribute(digimonTypeAttributeDto);

        return ResponseEntity.status(HttpStatus.CREATED).body("DIGIMON TYPE ATTRIBUTE CREATED");
    }
}

