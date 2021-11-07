package com.example.projectspting.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "unitgeo")
public class Unitgeo implements Serializable {
    @Id
    @SequenceGenerator(name="UNITGEO_ID_GENERATOR", sequenceName="UNITGEO_ID_SEQ")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="UNITGEO_ID_GENERATOR")
    private Integer id;
    private String unitgeoFr;
    private String unitgeoAngl;
    private String unitgeoPortu;
    private boolean csrp;

    @OneToMany(mappedBy = "unitgeo",fetch = FetchType.LAZY ,
               cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Surveillance> surveillances;

    @OneToMany(mappedBy = "unitgeo",fetch = FetchType.LAZY ,
            cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Demandeur> demandeurs;

    @OneToMany(mappedBy = "unitgeo",fetch = FetchType.LAZY ,
            cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Autorisation> autorisations;

    @OneToMany(mappedBy = "unitgeo",fetch = FetchType.LAZY ,
            cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Navire> navires;
}
