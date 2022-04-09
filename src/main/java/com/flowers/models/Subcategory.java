package com.flowers.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "subcategory")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subcategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subCategoryName", nullable = false, length = 30)
    private String subCategoryName;

    @Column(name = "description", nullable = false, length = 150)
    @Lob
    private String description;

    @ManyToOne
    @JoinColumn(name = "catId", nullable = false)
    private Category category;


}
