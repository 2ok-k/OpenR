package com.miage.openrh.models;

import com.miage.openrh.Database;

import java.sql.SQLException;
import java.util.ArrayList;

public class Entreprise {
    private String nom_entreprise;
    private String adresse_entreprise;
    private String email_entreprise;

    public Entreprise() {

    }

    public String getNom_entreprise() {
        return nom_entreprise;
    }

    public void setNom_entreprise(String nom_entreprise) {
        this.nom_entreprise = nom_entreprise;
    }

    public String getAdresse_entreprise() {
        return adresse_entreprise;
    }

    public void setAdresse_entreprise(String adresse_entreprise) {
        this.adresse_entreprise = adresse_entreprise;
    }

    public String getEmail_entreprise() {
        return email_entreprise;
    }

    public void setEmail_entreprise(String email_entreprise) {
        this.email_entreprise = email_entreprise;
    }

    public Entreprise(String nom_entreprise, String adresse_entreprise, String email_entreprise) {
        this.nom_entreprise = nom_entreprise;
        this.adresse_entreprise = adresse_entreprise;
        this.email_entreprise = email_entreprise;
    }
    public void save() throws SQLException {
        Database db = new Database("root", "", "openrh");

        db.connect();

        db.sendQuery("INSERT INTO entreprise (nom_entreprise,adresse_entreprise,email_entreprise) VALUES(?,?,?)", new ArrayList<>() {
            {
                add(nom_entreprise);
                add(adresse_entreprise);
                add(email_entreprise);
            }
        }, resultSet -> {

        });

        db.disconnect();
    }
}
