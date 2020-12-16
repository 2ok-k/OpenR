package com.miage.openrh.models;

import com.miage.openrh.Database;

import java.sql.SQLException;
import java.util.ArrayList;

public class Affectation {
    private String mat_emp;
    private String nom;
    private String prenom;
    private String structure_anterieur;
    private String nouvelle_structure;

    public Affectation() {

    }

    public String getMat_emp() {
        return mat_emp;
    }

    public void setMat_emp(String mat_emp) {
        this.mat_emp = mat_emp;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getStructure_anterieur() {
        return structure_anterieur;
    }

    public void setStructure_anterieur(String structure_anterieur) {
        this.structure_anterieur = structure_anterieur;
    }

    public String getNouvelle_structure() {
        return nouvelle_structure;
    }

    public void setNouvelle_structure(String nouvelle_structure) {
        this.nouvelle_structure = nouvelle_structure;
    }

    public Affectation(String mat_emp, String nom, String prenom, String structure_anterieur, String nouvelle_structure) {
        this.mat_emp = mat_emp;
        this.nom = nom;
        this.prenom = prenom;
        this.structure_anterieur = structure_anterieur;
        this.nouvelle_structure = nouvelle_structure;
    }

    public void save() throws SQLException {
        Database db = new Database("root", "", "openrh");

        db.connect();

        db.sendQuery("INSERT INTO affectation(mat_emp,nom,prenom,structure_anterieur,nouvelle_structure) VALUES(?,?,?,?,?)", new ArrayList<>() {
            {

                add(mat_emp);
                add(nom);
                add(prenom);
                add(structure_anterieur);
                add(nouvelle_structure);
            }
        }, resultSet -> {

        });

        db.disconnect();
    }

}
