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
@Table(name = "digimon_type")
public class DigimonTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "digimon_type_id")
    private Integer digimonTypeId;

    @Column(name = "digimon_type_name")
    private String digimonTypeName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "digimon_type_attribute",
            joinColumns = {@JoinColumn(name = "digimon_type_id", referencedColumnName = "digimon_type_id")},
            inverseJoinColumns = {@JoinColumn(name = "attribute_id", referencedColumnName = "attribute_id")})
    private List<DigimonTypeAttributeEntity> digimonTypeAttribute;
}