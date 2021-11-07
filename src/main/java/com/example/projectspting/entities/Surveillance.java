package com.example.projectspting.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "survaillance")
public class Surveillance implements Serializable {

    @Id
    @SequenceGenerator(name = "SURVEILLANCE_ID_GENERATOR", sequenceName = "SURVEILLANCE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SURVEILLANCE_ID_GENERATOR")
    private Long id;
    private String label;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModif;

    @OneToMany(mappedBy = "surveillance" , cascade = CascadeType.ALL,
               fetch = FetchType.LAZY,orphanRemoval = true)
    private Set<Controle> controles ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pays")
    private Unitgeo unitgeo;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type")
    private SurveillanceType surveillanceType;

    @Column(name="nbre_detecte")
    private Integer nbreDetecte;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date_patrouille")
    private Date datePatrouille;
    private String indicatif;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="heure_depart")
    private Date heureDepart;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="heure_arrivee")
    private Date heureArrivee;
    @Column(name="zone_patrouille")
    private String zonePatrouille;
    private boolean modifier;
    @Column(name="nbre_jour")
    private Double nbreJourMer;
    @ManyToOne
    private Utilisateur utilisateur;
    @ManyToMany
    private Set<Navire> navires ;

}
