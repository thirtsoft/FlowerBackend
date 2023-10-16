package com.flowers.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "country")
@Data
public class Country implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code_region", length = 30, unique = true)
    private String code;

    @Column(name = "nom_region", nullable = false, length = 90, unique = true)
    private String name;

    @OneToMany(mappedBy = "country")
    @JsonIgnore
    private List<State> stateList;

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

    public Country() {

    }

    public Country(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Country(Long id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }
}
