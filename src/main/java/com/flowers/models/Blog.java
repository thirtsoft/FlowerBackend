package com.flowers.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "historiqueLogin")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date createdDate;

    private String title;

    @Lob
    private String description;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Utilisateur utilisateur;
}
