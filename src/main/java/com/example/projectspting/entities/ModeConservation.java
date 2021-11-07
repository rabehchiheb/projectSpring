package com.example.projectspting.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "mode_conservation")
public class ModeConservation implements Serializable {
    @Id
    @SequenceGenerator(name="MODE_CONSERVATION_ID_GENERATOR", sequenceName="MODE_CONSERVATION_SEQ")
    @GeneratedValue(strategy= GenerationType.AUTO, generator="MODE_CONSERVATION_ID_GENERATOR")
    private Integer id;

    private String modeFr;

    private String modeAngl;
    private String modePortu;

}
