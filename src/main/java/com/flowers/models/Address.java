package com.flowers.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "zipcode", length = 90)
    private String zipcode;

    @Column(name = "ville", length = 70)
    private String city;

    @Column(name = "rue", length = 90)
    private String rue;

    @ManyToOne
    @JoinColumn(name = "stateId")
    // @JsonIgnore
    private State state;

    @OneToOne
    @PrimaryKeyJoinColumn
    @JsonIgnore
    private Commande commande;

    public Address(Long id, String city, String rue, State state) {
        this.id = id;
        this.city = city;
        this.rue = rue;
        this.state = state;
    }
}
