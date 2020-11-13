package com.miage.openrh.models;

import com.miage.openrh.Database;

import java.sql.SQLException;
import java.util.ArrayList;

public class AjoutEmploye {
    private String nom;
    private String prenom;
    private String genre;
    private String date_naiss;
    private String photo;
    private String pays;
    private String lieu_naiss;
    private String email;
    private String numero;
    private String situationMatri;
    private String poste;
    private String salaire;

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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDate_naiss() {
        return date_naiss;
    }

    public void setDate_naiss(String date_naiss) {
        this.date_naiss = date_naiss;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getLieu_naiss() {
        return lieu_naiss;
    }

    public void setLieu_naiss(String lieu_naiss) {
        this.lieu_naiss = lieu_naiss;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getSituationMatri() {
        return situationMatri;
    }

    public void setSituationMatri(String situationMatri) {
        this.situationMatri = situationMatri;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getSalaire() {
        return salaire;
    }

    public void setSalaire(String salaire) {
        this.salaire = salaire;
    }

    public AjoutEmploye(String nom, String prenom, String genre, String date_naiss, String photo, String pays, String lieu_naiss, String email, String numero, String situationMatri, String poste, String salaire) {
        this.nom = nom;
        this.prenom = prenom;
        this.genre = genre;
        this.date_naiss = date_naiss;
        this.photo = photo;
        this.pays = pays;
        this.lieu_naiss = lieu_naiss;
        this.email = email;
        this.numero = numero;
        this.situationMatri = situationMatri;
        this.poste = poste;
        this.salaire = salaire;
    }

    public void save() throws SQLException {
        Database db = new Database("root", "", "openrh");

        db.connect();

        db.sendQuery("INSERT INTO ajoutEmploye(nom,prenom,genre,date_naiss,photo,pays,lieu_naiss,email,numero,situationMatri,poste,salaire) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)", new ArrayList<>() {
            {
                add(nom);
                add(prenom);
                add(genre);
                add(date_naiss);
                add(photo);
                add(pays);
                add(lieu_naiss);
                add(email);
                add(numero);
                add(situationMatri);
                add(poste);
                add(salaire);

            }
        }, resultSet -> {

        });

        db.disconnect();
    }

}
