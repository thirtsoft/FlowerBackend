package com.flowers.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flowers.enums.RoleName;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "utilisateur", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
})
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName", length = 90)
    private String firstName;

    @Column(name = "lastName", length = 50)
    private String lastName;

    @Column(name = "username", length = 100)
    private String username;

    @Column(name = "email", length = 30)
    private String email;

    @Column(name = "mobile", length = 20)
    private String mobile;

    @Column(name = "address")
    private String address;

    @Column(name = "password", length = 100)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private RoleName roleName;

    @JsonIgnore
    @OneToMany(mappedBy = "utilisateur",
            fetch = FetchType.LAZY)
    private List<Order> orders;

}
