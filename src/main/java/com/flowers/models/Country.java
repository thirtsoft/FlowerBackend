package com.flowers.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "country")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCountry;

    @Column(name = "code", length = 30)
    private String code;

    @Column(name = "name", length = 90)
    private String name;

    @OneToMany(mappedBy = "country")
    @JsonIgnore
    private List<State> stateList;

    public Country(Long idCountry, String name) {
        this.idCountry = idCountry;
        this.name = name;
    }

    public Country(Long idCountry, String code, String name) {
        this.idCountry = idCountry;
        this.code = code;
        this.name = name;
    }
}
