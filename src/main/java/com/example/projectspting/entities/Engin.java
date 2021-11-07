package com.example.projectspting.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "engin")
public class Engin implements Serializable {

    @Id
    @SequenceGenerator(name="ENGIN_ID_GENERATOR", sequenceName="ENGIN_SEQ")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="ENGIN_ID_GENERATOR")
    private Integer id;

    private String enginAngl;

    private String enginFr;

    private String enginPortu;

    @ManyToMany

    @JoinTable(
            name = "autorisation_engins",
            joinColumns = @JoinColumn(name = "engin_id"),
            inverseJoinColumns = @JoinColumn(name = "autorisation_id"))
    private Set<Autorisation> autorisations ;

}
