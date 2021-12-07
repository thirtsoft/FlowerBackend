package com.flowers.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "email")
public class Email implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customerName")
    private String customerName;

    @Column(name = "recipient")
    private String recipient;

    @Column(name = "subject")
    private String subject;

    @Column(name = "message")
    @Lob
    private String message;

    @Column(name = "createDate")
    private Date createDate;

    @ManyToOne
    private Fournisseur fournisseur;

    @ManyToOne
    private Newsletter newsletter;
}
