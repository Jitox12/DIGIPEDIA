package com.DIGIPEDIA.Digimon.Collection.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "digimon_family")
public class DigimonFamilyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "digimon_family_id")
    private Integer digimonFamilyId;

    @Column(name = "digimon_family_name")
    private String digimonFamilyName;

    @OneToMany(mappedBy = "digimon_family", fetch = FetchType.EAGER)
    private List<DigimonEntity> digimons;
}
