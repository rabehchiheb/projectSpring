package com.example.projectspting.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name="navire_photo")
@NamedQuery(name="NavirePhoto.findAll", query="SELECT n FROM NavirePhoto n")
public class NavirePhoto implements Serializable {
    @Id
    @SequenceGenerator(name = "NAVIRE_PHOTO_ID_GENERATOR", sequenceName = "NAVIRE_PHOTO_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NAVIRE_PHOTO_ID_GENERATOR")
    private Long id;
    @Column(name="photo")
    private byte[] photo;
    private String extension;
    @Temporal(TemporalType.DATE)
    private Date datePrise;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModif;
    private boolean modifier;
    @ManyToOne
    private Navire navire ;

}
