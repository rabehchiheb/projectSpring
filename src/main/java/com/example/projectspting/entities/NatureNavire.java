package com.example.projectspting.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name="nature_navire")
@NamedQuery(name="NatureNavire.findAll", query="SELECT n FROM NatureNavire n")
public class NatureNavire implements Serializable {

    @Id
    @SequenceGenerator(name="NATURE_NAVIRE_ID_GENERATOR", sequenceName="NATURE_NAVIRE_SEQ")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="NATURE_NAVIRE_ID_GENERATOR")
    private Integer id;
    private String natureAngl;
    private String natureFr;
    private String naturePortu;

    @OneToMany(mappedBy = "natureNavire")
    private Set<NavireCaracteristique> navireCaracteristiques;

}
