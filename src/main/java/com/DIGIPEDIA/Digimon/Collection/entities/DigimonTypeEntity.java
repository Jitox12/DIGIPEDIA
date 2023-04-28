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

    @Lob
    @Column(name = "digimon_type_img")
    private byte[] digimonTYpeImg;
    @Column(name = "digimon_attribute_id")
    private Integer digimonAttributeId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "digimon_attribute_id",insertable = false, updatable = false)
    private AttributeEntity attribute;

    @OneToMany(mappedBy = "digimon_type")
    private List<DigimonEntity> digimons;
























}
