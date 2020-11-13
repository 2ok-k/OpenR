package com.miage.openrh.models;


import com.miage.openrh.Database;

import java.sql.SQLException;
import java.util.ArrayList;

public class PremiereInscrip {
    private String nom;
    private String prenom;
    private String poste;

    public PremiereInscrip() {

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

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public PremiereInscrip(String nom, String prenom, String poste) {
        this.nom = nom;
        this.prenom = prenom;
        this.poste = poste;
    }

    public void save() throws SQLException {
        Database db = new Database("root", "", "openrh");

        db.connect();
        try {
            db.sendQuery("INSERT INTO first(nom,prenom,poste) VALUES(?,?,?)", new ArrayList<>() {
                {
                    add(nom);
                    add(prenom);
                    add(poste);
                }
            }, resultSet -> {

            });
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
