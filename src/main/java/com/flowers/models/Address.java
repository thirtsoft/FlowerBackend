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

    @Column(name = "reference", length = 50)
    private String reference;

    @Column(name = "quartier", length = 90)
    private String quartier;

    @Column(name = "phone", length = 63)
    private String phone;

    @Column(name = "ville", length = 70)
    private String city;

    @Column(name = "rue", length = 90)
    private String rue;

    @ManyToOne
    @JoinColumn(name = "stateId")
    private State state;


    @OneToOne
    @PrimaryKeyJoinColumn
    @JsonIgnore
    private Order order;

    public Address(Long id, String reference, String quartier, String phone, String city, String rue, State state) {
        this.id = id;
        this.reference = reference;
        this.quartier = quartier;
        this.phone = phone;
        this.city = city;
        this.rue = rue;
        this.state = state;
    }
}
