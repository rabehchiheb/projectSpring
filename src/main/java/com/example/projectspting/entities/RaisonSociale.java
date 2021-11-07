package com.example.projectspting.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "raison_sociale")
public class RaisonSociale  implements Serializable {

    @Id
    @SequenceGenerator(name="RAISON_SOCIALE_ID_GENERATOR", sequenceName="RAISON_SOCIALE_SEQ")
    @GeneratedValue(strategy= GenerationType.AUTO, generator="RAISON_SOCIALE_ID_GENERATOR")
    private Integer id;
    private String rsFr;
    private String rsAngl;
    private String rsPortu;

    @OneToMany(mappedBy = "raisonSociale" , fetch = FetchType.LAZY ,
               cascade = CascadeType.ALL ,orphanRemoval = true)
    private Set<Demandeur> demandeurs;
}
