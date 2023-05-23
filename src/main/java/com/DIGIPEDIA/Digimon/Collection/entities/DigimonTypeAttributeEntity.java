package com.DIGIPEDIA.Digimon.Collection.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "digimon_type_attribute")
public class DigimonTypeAttributeEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "digimon_type_attribute_id")
    private Integer digimonTypeAttributeId;
    @Column(name = "digimon_type_id")
    private Integer digimonTypeId;
    @Column(name = "attribute_id")
    private Integer attributeId;

    @Column(name = "digimon_type_attribute_name")
    private String digimonTypeAttributeName;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "digimon_type_attribute_img", columnDefinition = "bigint" )
    private byte[] digimonTypeAttributeImg;

    @OneToMany(mappedBy = "digimon_type_attribute", fetch = FetchType.EAGER)
    private List<DigimonEntity> digimons;
}