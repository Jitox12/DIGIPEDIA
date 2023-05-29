package com.DIGIPEDIA.Digimon.Collection.controllers;

import com.DIGIPEDIA.Digimon.Collection.dto.evolutionDto.CEvolutionDto;
import com.DIGIPEDIA.Digimon.Collection.dto.involutionDto.CInvolutionDto;
import com.DIGIPEDIA.Digimon.Collection.services.InvolutionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/involution")
public class InvolutionController {

    private final InvolutionService involutionService;

    public InvolutionController(InvolutionService involutionService) {
        this.involutionService = involutionService;
    }

    @PostMapping(value = "/involve")
    public ResponseEntity<String> evolveDigimonController(@RequestBody CInvolutionDto involutionDto) {

        involutionService.involveDigimonService(involutionDto);

        return ResponseEntity.status(HttpStatus.CREATED).body("INVOLUTION & EVOLUTION CREATED");
    }
}
