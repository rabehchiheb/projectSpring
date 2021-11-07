package com.example.projectspting.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "module")
@NamedQuery(name = "Module.findAll", query = "SELECT m FROM Module m")
public class Module implements Serializable {
    @Id
    @SequenceGenerator(name = "MODULE_ID_GENERATOR",sequenceName = "MODULE_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "MODULE_ID_GENERATOR")
    private Integer id;
    private String code;
    private String moduleAngl;
    private String moduleFr;
    private String modulePortu;

    @OneToMany(mappedBy = "module")
    private Set<Fonction> fonctions ;

}
