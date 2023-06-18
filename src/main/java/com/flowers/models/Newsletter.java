package com.flowers.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "newsletter")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Newsletter implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", length = 90)
    private String code;

    @Column(name = "customerEmail", length = 90)
    private String customerEmail;

    @Column(name = "subject", length = 120)
    private String subject;

    @Column(name = "message")
    private String message;

    @Column(name = "dateInscription", length = 50)
    private Date dateInscription;

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
