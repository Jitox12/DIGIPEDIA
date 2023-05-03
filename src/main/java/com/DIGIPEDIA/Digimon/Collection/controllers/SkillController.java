package com.DIGIPEDIA.Digimon.Collection.controllers;

import com.DIGIPEDIA.Digimon.Collection.dto.skillDto.CSkillDto;
import com.DIGIPEDIA.Digimon.Collection.dto.skillDto.GASkillDto;
import com.DIGIPEDIA.Digimon.Collection.dto.skillDto.GSkillDto;
import com.DIGIPEDIA.Digimon.Collection.services.SkillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/skill")
public class SkillController {

    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<String> createSkillController(@RequestBody CSkillDto skillDto){
        skillService.createSkill(skillDto);

        return ResponseEntity.status(HttpStatus.CREATED).body("SKILL CREATED");
    }

    @GetMapping(value = "/findbyid/{skillId}")
    public GASkillDto findSkillByIdController(@PathVariable Integer skillId){
        GASkillDto skillDto;
        skillDto = skillService.findSkillById(skillId);

        return skillDto;
    }

    @GetMapping(value = "/findbyname/{skillName}")
    public GASkillDto findSkillByNameController(@PathVariable String skillName){
        GASkillDto skillDto;
        skillDto = skillService.findSkillByName(skillName);

        return skillDto;
    }

    @GetMapping(value = "/findall")
    public List<GSkillDto> findAllSkillController(){
        List<GSkillDto> skillDtoList;

        skillDtoList = skillService.findAllSkills();

        return skillDtoList;
    }
}
