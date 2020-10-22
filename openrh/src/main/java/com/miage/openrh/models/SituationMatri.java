package com.miage.openrh.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id_sit")
public class SituationMatri {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_sit;
    private String lib_sit;

    @OneToMany(mappedBy = "employe")
    private List<Employe> employes;
}
