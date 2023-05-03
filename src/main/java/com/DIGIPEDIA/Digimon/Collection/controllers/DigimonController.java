package com.DIGIPEDIA.Digimon.Collection.controllers;

import com.DIGIPEDIA.Digimon.Collection.dto.digimonDto.CDigimonDto;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonDto.GADigimonDto;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonDto.GDigimonDto;
import com.DIGIPEDIA.Digimon.Collection.services.DigimonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/digimon")
public class DigimonController {

    private final DigimonService digimonService;

    public DigimonController(DigimonService digimonService) {
        this.digimonService = digimonService;
    }

    @GetMapping(value = "/findbyid/{digimonId}")
    public GADigimonDto findDigimonByIdController(@PathVariable Integer digimonId){
        GADigimonDto digimonDto;
        digimonDto = digimonService.findDigimonById(digimonId);

        return digimonDto;
    }

    @GetMapping(value = "/findbyname/{digimonName}")
    public GADigimonDto findDigimonByNameController(@PathVariable String digimonName){
        GADigimonDto digimonDto;
        digimonDto = digimonService.findDigimonByName(digimonName);

        return digimonDto;
    }

    @GetMapping(value = "/findall")
    public List<GDigimonDto> findAllDigimonsController() {
        List<GDigimonDto> digimonDtoList;
        digimonDtoList = digimonService.findAllDigimon();

        return digimonDtoList;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<String> createDigimonController(@RequestBody CDigimonDto digimonDto){
        digimonService.createDigimon(digimonDto);

        return ResponseEntity.status(HttpStatus.CREATED).body("DIGIMON CREATED");
    }





}
