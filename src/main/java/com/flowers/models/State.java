package com.flowers.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "state")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class State implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom_quartier", nullable = false, length = 90, unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "countryId")
    private Country country;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zone_livraison_uid")
    private ZoneLivraison zoneLivraison;

    @Column(name = "actif")
    private int actif;

    public void setActif(boolean actif) {
        if (actif == true)
            this.actif = 1;
        else
            this.actif = 0;
    }

    public boolean isActif() {
        if (actif == 1)
            return true;
        else
            return false;
    }

}