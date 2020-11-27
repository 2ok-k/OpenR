package com.miage.openrh.models;


import com.miage.openrh.Database;

import java.sql.SQLException;
import java.util.ArrayList;

public class DemandePermission {
    private String mat_emp;
    private String nom;
    private String prenom;
    private String date_depart;
    private String date_retour;
    private String motif;

    public DemandePermission() {

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

    public String getDate_depart() {
        return date_depart;
    }

    public void setDate_depart(String date_depart) {
        this.date_depart = date_depart;
    }

    public String getDate_retour() {
        return date_retour;
    }

    public void setDate_retour(String date_retour) {
        this.date_retour = date_retour;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public DemandePermission(String mat_emp, String nom, String prenom, String date_depart, String date_retour, String motif) {
        this.mat_emp = mat_emp;
        this.nom = nom;
        this.prenom = prenom;
        this.date_depart = date_depart;
        this.date_retour = date_retour;
        this.motif = motif;
    }
    public void save() throws SQLException {
        Database db = new Database("root", "", "openrh");

        db.connect();

        db.sendQuery("INSERT INTO demandepermission(mat_emp,nom,prenom,date_depart,date_retour,motif) VALUES(?,?,?,?,?,?)", new ArrayList<>() {
            {
                add(mat_emp);
                add(nom);
                add(prenom);
                add(date_depart);
                add(date_retour);
                add(motif);
            }
        }, resultSet -> {

        });

        db.disconnect();
    }
}
