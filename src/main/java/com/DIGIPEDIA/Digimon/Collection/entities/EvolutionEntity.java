package com.DIGIPEDIA.Digimon.Collection.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "evolution")
public class EvolutionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evolution_id")
    private Integer evolutionId;

    @Column(name = "digimon_id")
    private Integer digimonId;

    @Column(name = "digimon_evolved_id")
    private Integer digimonEvolvedId;
}