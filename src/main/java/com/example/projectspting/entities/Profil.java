package com.example.projectspting.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "profil")
public class Profil implements Serializable {

    @Id
    @SequenceGenerator(name="PROFIL_ID_GENERATOR", sequenceName="PROFIL_SEQ")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="PROFIL_ID_GENERATOR")
    private Integer id;
    private String profilFr;
    private String profilAngl;
    private String profilPortu;
    private String code;
}
