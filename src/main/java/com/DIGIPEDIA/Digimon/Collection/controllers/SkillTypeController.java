package com.DIGIPEDIA.Digimon.Collection.controllers;

import com.DIGIPEDIA.Digimon.Collection.dto.skillTypeDto.CSkillTypeDto;
import com.DIGIPEDIA.Digimon.Collection.dto.skillTypeDto.GASkillTypeDto;
import com.DIGIPEDIA.Digimon.Collection.dto.skillTypeDto.GSkillTypeDto;
import com.DIGIPEDIA.Digimon.Collection.services.SkillTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/skilltype")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class SkillTypeController {

    private final SkillTypeService skillTypeService;

    public SkillTypeController(SkillTypeService skillTypeService) {
        this.skillTypeService = skillTypeService;
    }

    @GetMapping(value = "/findbyid/{skillTypeId}")
    public GASkillTypeDto findSkillTypeByIdController(@PathVariable Integer skillTypeId){
        GASkillTypeDto skillTypeDto;
        skillTypeDto = skillTypeService.findSkillTypeById(skillTypeId);

        return skillTypeDto;
    }

    @GetMapping(value = "/findbyname/{skillTypeName}")
    public GASkillTypeDto findSkillTypeByNameController(@PathVariable String skillTypeName){
        GASkillTypeDto skillTypeDto;
        skillTypeDto = skillTypeService.findSkillTypeByName(skillTypeName);

        return skillTypeDto;
    }

    @GetMapping(value = "/findall")
    public List<GSkillTypeDto> findAllSkillTypesController(){
        List<GSkillTypeDto> skillTypeDtoList;
        skillTypeDtoList = skillTypeService.findAllSkillTypes();

        return skillTypeDtoList;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<String> createSkillTypeController(@RequestBody CSkillTypeDto skillTypeDto){
        skillTypeService.createSkillType(skillTypeDto);

        return ResponseEntity.status(HttpStatus.CREATED).body("SKILL TYPE CREATED");
    }
}
