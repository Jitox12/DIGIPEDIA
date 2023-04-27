package com.DIGIPEDIA.Digimon.Collection.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "digimon")
public class DigimonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "digimon_id")
    private Integer digimonId;
    @Column(name = "digimon_memory")
    private Integer digimonMemory;
    @Column(name = "digimon_name")
    private String digimonName;
    @Column(name = "digimon_img")
    private String digimonImg;

    @Column(name = "digimon_passive")
    private String digimonPassive;
    @Column(name = "digimon_type_id")
    private Integer digimonTypeId;

    @Column(name = "digimon_family_id")
    private Integer digimonFamilyId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "digimon_family_id",insertable = false, updatable = false)
    private DigimonFamilyEntity digimon_family;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "digimon_type_id",insertable = false, updatable = false)
    private DigimonFamilyEntity digimon_type;
}