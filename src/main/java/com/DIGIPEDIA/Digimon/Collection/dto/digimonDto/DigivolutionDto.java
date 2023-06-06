package com.DIGIPEDIA.Digimon.Collection.dto.digimonDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DigivolutionDto {

    @Id
    @Column(name = "digimon_id")
    private Integer digimonEvolvedId;

    @Column(name = "digimon_name")
    private String digimonName;

    @Lob
    @Column(name = "digimon_img")
    private byte[] digimonImg;
}