package com.miage.openrh.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "mat_emp")
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="mat_emp")

    @ManyToOne
    @JoinColumn(name = "id_genre",insertable = false,updatable = false)
    private Genre genre;
    private int id_genre;

    private String nom;
    private String prenom;
    private String lieu_naiss;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_naiss;

    private String adresse;
    private String pays_naiss;
    private String ville_naiss;
    private String numero;
    private String email;
    private String salaire;
    private String piece_identite;
    private String piece_jointe;
    private String role;

    @ManyToOne
    @JoinColumn(name = "id_sit",insertable = false,updatable = false)
    private SituationMatri situationMatri;
    private String id_sit;
}
