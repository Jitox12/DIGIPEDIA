package com.DIGIPEDIA.Digimon.Collection.controllers;

import com.DIGIPEDIA.Digimon.Collection.dto.evolutionDto.CEvolutionDto;
import com.DIGIPEDIA.Digimon.Collection.dto.involutionDto.CInvolutionDto;
import com.DIGIPEDIA.Digimon.Collection.services.InvolutionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/involution")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})

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
