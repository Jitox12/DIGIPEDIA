package com.DIGIPEDIA.Digimon.Collection.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "digimon_skill")
public class DigimonSkillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "digimon_skill_id")
    private Integer digimonSkillId;

    @Column(name = "digimon_id")
    private Integer digimonId;

    @Column(name="skill_id")
    private Integer skillId;
}
