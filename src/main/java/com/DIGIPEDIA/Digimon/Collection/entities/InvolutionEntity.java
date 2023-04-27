package com.DIGIPEDIA.Digimon.Collection.entities;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "involution")
public class InvolutionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "involution_id")
    private Integer involutionId;

    @Column(name = "digimon_id")
    private Integer digimonId;

    @Column(name = "digimon_involved_id")
    private Integer digimonInvolvedId;
}
