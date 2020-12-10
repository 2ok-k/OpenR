package com.miage.openrh.models;

import com.miage.openrh.Database;

import java.sql.SQLException;
import java.util.ArrayList;

public class Paie {
    private String mat_emp;
    private String nom;
    private String prenom;
    private String poste;
    private String mois;
    private Integer salaire_base;
    private Integer sursalaire;
    private Integer prime_anciennete;
    private Integer contri_nationale;
    private Integer impot_salaire;
    private Integer impot_revenu;
    private Integer cnps;
    private Integer net_payer;

    public Paie() {

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

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }

    public Integer getSalaire_base() {
        return salaire_base;
    }

    public void setSalaire_base(Integer salaire_base) {
        this.salaire_base = salaire_base;
    }

    public Integer getSursalaire() {
        return sursalaire;
    }

    public void setSursalaire(Integer sursalaire) {
        this.sursalaire = sursalaire;
    }

    public Integer getPrime_anciennete() {
        return prime_anciennete;
    }

    public void setPrime_anciennete(Integer prime_anciennete) {
        this.prime_anciennete = prime_anciennete;
    }

    public Integer getContri_nationale() {
        return contri_nationale;
    }

    public void setContri_nationale(Integer contri_nationale) {
        this.contri_nationale = contri_nationale;
    }

    public Integer getImpot_salaire() {
        return impot_salaire;
    }

    public void setImpot_salaire(Integer impot_salaire) {
        this.impot_salaire = impot_salaire;
    }

    public Integer getImpot_revenu() {
        return impot_revenu;
    }

    public void setImpot_revenu(Integer impot_revenu) {
        this.impot_revenu = impot_revenu;
    }

    public Integer getCnps() {
        return cnps;
    }

    public void setCnps(Integer cnps) {
        this.cnps = cnps;
    }

    public Integer getNet_payer() {
        return net_payer;
    }

    public void setNet_payer(Integer net_payer) {
        this.net_payer = net_payer;
    }

    public Paie(String mat_emp, String nom, String prenom, String poste, String mois, Integer salaire_base, Integer sursalaire, Integer prime_anciennete, Integer contri_nationale, Integer impot_salaire, Integer impot_revenu, Integer cnps, Integer net_payer) {
        this.mat_emp = mat_emp;
        this.nom = nom;
        this.prenom = prenom;
        this.poste = poste;
        this.mois = mois;
        this.salaire_base = salaire_base;
        this.sursalaire = sursalaire;
        this.prime_anciennete = prime_anciennete;
        this.contri_nationale = contri_nationale;
        this.impot_salaire = impot_salaire;
        this.impot_revenu = impot_revenu;
        this.cnps = cnps;
        this.net_payer = net_payer;
    }

    public void save() throws SQLException {
        Database db = new Database("root", "", "openrh");

        db.connect();

        db.sendQuery("INSERT INTO paie(mat_emp,nom,prenom,poste,mois,net_payer,salaire_base,sursalaire,prime_anciennete,contri_nationale,impot_salaire,impot_revenu,cnps) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)", new ArrayList<>() {
            {
                add(mat_emp);
                add(nom);
                add(prenom);
                add(poste);
                add(mois);
                add(net_payer);
                add(salaire_base);
                add(sursalaire);
                add(prime_anciennete);
                add(contri_nationale);
                add(impot_salaire);
                add(impot_revenu);
                add(cnps);

            }
        }, resultSet -> {

        });

        db.disconnect();
    }
}
