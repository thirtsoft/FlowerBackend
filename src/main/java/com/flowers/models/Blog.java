package com.flowers.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "blog", uniqueConstraints = {
        @UniqueConstraint(columnNames = "title"),
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Lob
    private String description;

    private String image;

    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Utilisateur utilisateur;
}
