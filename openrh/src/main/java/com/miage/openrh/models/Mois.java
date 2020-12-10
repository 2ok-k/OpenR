package com.miage.openrh.models;

import com.miage.openrh.Database;

import java.sql.SQLException;
import java.util.ArrayList;

public class Mois {
    private Integer id_mois;
    private String lib_mois;

    public Mois() {

    }

    public Integer getId_mois() {
        return id_mois;
    }

    public void setId_mois(Integer id_mois) {
        this.id_mois = id_mois;
    }

    public String getLib_mois() {
        return lib_mois;
    }

    public void setLib_mois(String lib_mois) {
        this.lib_mois = lib_mois;
    }

    public Mois(Integer id_mois, String lib_mois) {
        this.id_mois = id_mois;
        this.lib_mois = lib_mois;
    }

    public void save() throws SQLException {
        Database db = new Database("root", "", "openrh");

        db.connect();

        db.sendQuery("INSERT INTO mois (id_mois,lib_mois) VALUES(?,?)", new ArrayList<>() {
            {
                add(id_mois);
                add(lib_mois);
            }
        }, resultSet -> {

        });

        db.disconnect();
    }
}
