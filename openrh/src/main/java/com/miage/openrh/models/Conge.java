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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id_conge")
public class Conge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_conge")
    private Integer id_conge;
    private String mat_emp;

    @ManyToOne
    @JoinColumn(name = "id_type_conge", insertable = false,updatable = false)
    private TypeConge typeConge;
    private int id_type_conge;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_depart;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_demande;

    private int duree;
}

