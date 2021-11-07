package com.example.projectspting.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "activite_bateau")
public class ActiviteBateau implements Serializable {

    @Id
    @SequenceGenerator(name = "ACTIVITIES_ID_GENERATOR", sequenceName = "ACTIVITIES_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACTIVITIES_ID_GENERATOR")
    private Integer id;
    @Column(name="label_fr")
    private String labelFr;
    @Column(name="label_en")
    private String labelEn;
    @Column(name="label_pr")
    private String labelPr;

    @OneToMany(mappedBy = "activite" , fetch = FetchType.LAZY ,
               cascade = CascadeType.ALL , orphanRemoval = true)
    private Set<Controle> controles;
}
