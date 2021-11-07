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
@Table(name = "navire")
public class Navire implements Serializable {
    @Id
    @SequenceGenerator(name = "NAVIRE_ID_GENERATOR", sequenceName = "NAVIRE_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "NAVIRE_ID_GENERATOR")
    private Long id;
    private String numCsrp;
    private String imo;
    private String nom;
    private String nomOrigin;
    private String nomPrecedent;

    private String nomCapitaine;
    private String immatriculation;
    private String nationaliteOrigine;
    @Temporal(TemporalType.DATE)
    private Date datePavillon;

    @Temporal(TemporalType.DATE)
    private Date dateConstruction;

    private String lieuConstruction;
    private String portAttache;
    private String indicatifAppelRadio;
    private String indicatifAppelRadioPrecedent;
    private String certifNavig;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModif;
    private boolean modifier;

    @ManyToOne
    private Utilisateur utilisateur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pays")
    private Unitgeo unitgeo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pays_emis_cerif_navig")
    private Unitgeo paysEmisCerifNavig;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pavillon")
    private Pavillon pavillon;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proprietaire")
    private Demandeur proprietaire;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ancien_proprietaire")
    private Demandeur ancienProprietaire;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nationalite")
    private Unitgeo nationalite;

    @Transient
    private Integer nbreLicence ;
    @OneToMany(mappedBy = "navire" , cascade = CascadeType.ALL ,
               fetch = FetchType.LAZY , orphanRemoval = true)
    private Set<Infraction> infractions;

    @OneToMany(mappedBy = "navire" , cascade = CascadeType.ALL ,
            fetch = FetchType.LAZY , orphanRemoval = true)
    private Set<NavireCaracteristique> navireCaracteristiques;

    @OneToMany(mappedBy = "navire" , cascade = CascadeType.ALL ,
            fetch = FetchType.LAZY , orphanRemoval = true)
    private Set<NavireConservation> navireConservations;

    @OneToMany(mappedBy = "navire" , cascade = CascadeType.ALL ,
            fetch = FetchType.LAZY , orphanRemoval = true)
    private Set<NavirePhoto> navirePhotos;

    @ManyToMany
    private Set<Surveillance> surveillances ;
}
