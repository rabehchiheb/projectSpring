package com.example.projectspting.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name="type_balise")
@NamedQuery(name="TypeBalise.findAll", query="SELECT t FROM TypeBalise t")
public class TypeBalise implements Serializable {

    @Id
    @SequenceGenerator(name="TYPE_BALISE_ID_GENERATOR", sequenceName="TYPE_BALISE_SEQ")
    @GeneratedValue(strategy= GenerationType.AUTO, generator="TYPE_BALISE_ID_GENERATOR")
    private Integer id;
    private String typeAngl;
    private String typeFr;
    private String typePortu;

    @OneToMany(mappedBy = "typeBalise")
    private Set<NavireCaracteristique> navireCaracteristiques;

    @ManyToOne
    private Utilisateur utilisateur;

}
