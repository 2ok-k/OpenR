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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "num_perm")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_perm")
    private String mat_emp;

    @ManyToOne
    @JoinColumn(name = "id_type_perm",insertable = false,updatable = false)
    private TypePermission typePermission;
    private int id_type_perm;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_depart;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_demande;

    private int duree;
    private String motif;
}
