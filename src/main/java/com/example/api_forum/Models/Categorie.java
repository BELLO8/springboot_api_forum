package com.example.api_forum.Models;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "categorie")
public class Categorie implements Serializable {

    @Id
    @SequenceGenerator(
            name = "cate_sequence",
            sequenceName = "cate_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cate_sequence")
    private long id;

    @Column(
            name ="categorie",
            nullable = false,
            columnDefinition = "TEXT")
    private String categorie;

    public Categorie(long id, String categorie) {
        this.id = id;
        this.categorie = categorie;
    }

    public Categorie() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

}
