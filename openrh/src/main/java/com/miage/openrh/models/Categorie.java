package com.miage.openrh.models;

import com.miage.openrh.Database;

import java.sql.SQLException;
import java.util.ArrayList;

public class Categorie {
    private Integer id_cat;
    private String lib_cat;

    public Categorie() {

    }

    public Integer getId_cat() {
        return id_cat;
    }

    public void setId_cat(Integer id_cat) {
        this.id_cat = id_cat;
    }

    public String getLib_cat() {
        return lib_cat;
    }

    public void setLib_cat(String lib_cat) {
        this.lib_cat = lib_cat;
    }

    public Categorie(Integer id_cat, String lib_cat) {
        this.id_cat = id_cat;
        this.lib_cat = lib_cat;
    }

    public void save() throws SQLException {
        Database db = new Database("root", "", "openrh");

        db.connect();

        db.sendQuery("INSERT INTO categorie (id_cat,lib_cat) VALUES(?,?)", new ArrayList<>() {
            {
                add(id_cat);
                add(lib_cat);
            }
        }, resultSet -> {

        });

        db.disconnect();
    }
}
