package com.example.projectspting.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "utilisateur")
public class Utilisateur implements Serializable {

    @Id
    @SequenceGenerator(name="UTILISATEUR_ID_GENERATOR", sequenceName="UTILISATEUR_SEQ")
    @GeneratedValue(strategy= GenerationType.AUTO, generator="UTILISATEUR_ID_GENERATOR")
    private Integer id;
    private String 	nom;
    private String prenom;
    private String login;
    private String password;
    private String contact;
    private String adresse;
    @Column(unique=true)
    private String email;
    private boolean active;
    private Boolean changerPassword;
    private boolean withLdap;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModif;

    @OneToMany(mappedBy = "utilisateur" , cascade = CascadeType.ALL ,
               orphanRemoval = true,fetch = FetchType.LAZY)
    private Set<Autorisation> autorisations ;

    @OneToMany(mappedBy = "utilisateur" , cascade = CascadeType.ALL ,
            orphanRemoval = true,fetch = FetchType.LAZY)
    private Set<Surveillance> surveillances ;

    @OneToMany(mappedBy = "utilisateur" , cascade = CascadeType.ALL ,
            orphanRemoval = true,fetch = FetchType.LAZY)
    private Set<Demandeur> demandeurs ;

    @OneToMany(mappedBy = "utilisateur" , cascade = CascadeType.ALL ,
            orphanRemoval = true,fetch = FetchType.LAZY)
    private Set<Navire>  navires ;

    @OneToMany(mappedBy = "utilisateur" , cascade = CascadeType.ALL ,
            orphanRemoval = true,fetch = FetchType.LAZY)
    private Set<Infraction>  infractions ;
}
