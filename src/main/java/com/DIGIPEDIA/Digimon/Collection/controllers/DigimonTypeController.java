package com.DIGIPEDIA.Digimon.Collection.controllers;

import com.DIGIPEDIA.Digimon.Collection.dto.digimonTypeDto.CDigimonTypeDto;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonTypeDto.GADigimonTypeDto;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonTypeDto.GDigimonTypeDto;
import com.DIGIPEDIA.Digimon.Collection.services.DigimonTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/digimontype")
public class DigimonTypeController {

    private final DigimonTypeService digimonTypeService;

    public DigimonTypeController(DigimonTypeService digimonTypeService) {
        this.digimonTypeService = digimonTypeService;
    }


    @GetMapping(value = "/findbyid/{digimonTypeId}")
    public GADigimonTypeDto findDigimonTypeByIdController(@PathVariable Integer digimonTypeId){
        GADigimonTypeDto digimonTypeDto;
        digimonTypeDto = digimonTypeService.findDigimonTypeById(digimonTypeId);

        return digimonTypeDto;
    }
    @GetMapping(value = "/findbyname/{digimonTypeName}")
    public GADigimonTypeDto findDigimonTypeByNameController(@PathVariable String digimonTypeName){
        GADigimonTypeDto digimonTypeDto;
        digimonTypeDto = digimonTypeService.findDigimonTypeByName(digimonTypeName);

        return digimonTypeDto;
    }
    @GetMapping(value = "/findall")
    public List<GDigimonTypeDto> findAllDigimonTypesController(){
        List<GDigimonTypeDto> digimonTypeDtoList ;
        digimonTypeDtoList = digimonTypeService.findAllDigimonTypes();

        return digimonTypeDtoList;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<String> createDigimonTypeController(@RequestBody CDigimonTypeDto digimonTypeDto){
        digimonTypeService.createDigimonType(digimonTypeDto);

        return ResponseEntity.status(HttpStatus.CREATED).body("DIGIMON TYPE CREATED");
    }
}
