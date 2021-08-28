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
    @Column(name = "id")
    private Long idState;

    @Column(name = "name", length = 90)
    private String name;

    @ManyToOne
    private Country country;
}
