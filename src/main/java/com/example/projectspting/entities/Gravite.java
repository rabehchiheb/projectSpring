package com.example.projectspting.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "gravite")
public class Gravite implements Serializable {

    @Id
    @SequenceGenerator(name = "GRAVITE_ID_GENERATOR", sequenceName = "GRAVITE_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "GRAVITE_ID_GENERATOR")
    private Integer id;
    @Column(name="code")
    private String code;
    @Column(name="label_fr")
    private String labelFr;
    @Column(name="label_en")
    private String labelEn;
    @Column(name="label_pr")
    private String labelPr;
    @OneToMany(mappedBy = "gravite")
    private Set<InfractionNature> infractionNatures;
}
