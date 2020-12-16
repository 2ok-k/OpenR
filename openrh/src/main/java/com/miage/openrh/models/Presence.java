package com.miage.openrh.models;

import com.miage.openrh.Database;

import java.sql.SQLException;
import java.util.ArrayList;

public class Presence {
    private String mat_emp;
    private String nom;
    private String prenom;
    private String date;
    private String heure_arrive;

    public Presence() {

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure_arrive() {
        return heure_arrive;
    }

    public void setHeure_arrive(String heure_arrive) {
        this.heure_arrive = heure_arrive;
    }

    public Presence(String mat_emp, String nom, String prenom, String date, String heure_arrive) {
        this.mat_emp = mat_emp;
        this.nom = nom;
        this.prenom = prenom;
        this.date = date;
        this.heure_arrive = heure_arrive;
    }
    public void save() throws SQLException {
        Database db = new Database("root", "", "openrh");

        db.connect();

        db.sendQuery("INSERT INTO presence(mat_emp,nom,prenom,date,heure_arrive) VALUES(?,?,?,?,?)", new ArrayList<>() {
            {
                add(mat_emp);
                add(nom);
                add(prenom);
                add(date);
                add(heure_arrive);

            }
        }, resultSet -> {

        });

        db.disconnect();
    }
}
