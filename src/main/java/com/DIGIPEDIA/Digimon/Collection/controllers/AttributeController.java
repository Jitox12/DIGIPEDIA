package com.DIGIPEDIA.Digimon.Collection.controllers;

import com.DIGIPEDIA.Digimon.Collection.dto.attributeDto.CAttributeDto;
import com.DIGIPEDIA.Digimon.Collection.dto.attributeDto.GAAttributeDto;
import com.DIGIPEDIA.Digimon.Collection.dto.attributeDto.GAttributeDto;
import com.DIGIPEDIA.Digimon.Collection.services.AttributeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/attribute")
public class AttributeController {

    private final AttributeService attributeService;

    public AttributeController(AttributeService attributeService) {
        this.attributeService = attributeService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<String> createAttributeController(@RequestBody CAttributeDto attributeDto) {
        attributeService.createAttribute(attributeDto);

        return ResponseEntity.status(HttpStatus.CREATED).body("CREATED");
    }

    @GetMapping(value = "/findbyid/{attributeId}")
    public GAAttributeDto findAttributeByIdController(@PathVariable Integer attributeId){
        GAAttributeDto attributeDto;

        attributeDto = attributeService.findAttributeById(attributeId);

        return attributeDto;
    }
    @GetMapping(value = "/findbyname/{attributeName}")
    public GAAttributeDto findAttributeByNameController(@PathVariable String attributeName){
        GAAttributeDto attributeDto;

        attributeDto = attributeService.findAttributeByName(attributeName);

        return attributeDto;
    }
    @GetMapping(value = "/findall")
    public List<GAttributeDto> findAllAttribute(){
        List<GAttributeDto> attributeDtoList;

        attributeDtoList = attributeService.findAllAttribute();

        return attributeDtoList;
    }
}
