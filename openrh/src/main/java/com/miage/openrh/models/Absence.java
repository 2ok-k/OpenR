package com.miage.openrh.models;

import com.miage.openrh.Database;

import java.sql.SQLException;
import java.util.ArrayList;

public class Absence {
    private String mat_emp;
    private String nom;
    private String date_absence;
    private Integer duree;

    public Absence() {

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

    public String getDate_absence() {
        return date_absence;
    }

    public void setDate_absence(String date_absence) {
        this.date_absence = date_absence;
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    public Absence(String mat_emp, String nom, String date_absence, Integer duree) {
        this.mat_emp = mat_emp;
        this.nom = nom;
        this.date_absence = date_absence;
        this.duree = duree;
    }
    public void save() throws SQLException {
        Database db = new Database("root", "", "openrh");

        db.connect();

        db.sendQuery("INSERT INTO absence(mat_emp,nom,date_absence,duree) VALUES(?,?,?,?)", new ArrayList<>() {
            {
                add(mat_emp);
                add(nom);
                add(date_absence);
                add(duree);

            }
        }, resultSet -> {

        });

        db.disconnect();
    }
}
