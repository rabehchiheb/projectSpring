package com.example.projectspting.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "controle")
public class Controle implements Serializable {

    @Id
    @SequenceGenerator(name = "CONTROLE_ID_GENERATOR", sequenceName = "CONTROLE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTROLE_ID_GENERATOR")
    private Long id;

    private String nom;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModif;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pays")
    private Unitgeo unitgeo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "activite_bateau")
    private ActiviteBateau activite;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date_observation")
    private Date dateObservation;

    private String zee;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="heure_observation")
    private Date heureObservation;

    private boolean photo;

    private String longitude;

    private String latitude;

    @Column(name="zone_peche")
    private String zonePeche;

    private boolean modifier;

    @ManyToOne
    private Surveillance surveillance ;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="navire")
    private Navire navire;

}
