package com.flowers.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "historiqueCommande")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoriqueCommande implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date createdDate;

    private String action;

    @ManyToOne
    @JoinColumn(name = "comId")
    private Commande commande;
}
