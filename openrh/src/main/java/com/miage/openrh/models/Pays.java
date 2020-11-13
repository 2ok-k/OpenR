package com.miage.openrh.models;

import com.miage.openrh.Database;

import java.sql.SQLException;
import java.util.ArrayList;

public class Pays {
    private Integer id_pays;
    private String lib_pays;

    public Pays() {

    }

    public Integer getId_pays() {
        return id_pays;
    }

    public void setId_pays(Integer id_pays) {
        this.id_pays = id_pays;
    }

    public String getLib_pays() {
        return lib_pays;
    }

    public void setLib_pays(String lib_pays) {
        this.lib_pays = lib_pays;
    }

    public Pays(Integer id_pays, String lib_pays) {
        this.id_pays = id_pays;
        this.lib_pays = lib_pays;
    }

    public void save() throws SQLException {
        Database db = new Database("root", "", "openrh");

        db.connect();

        db.sendQuery("INSERT INTO pays (id_pays,lib_pays) VALUES(?,?)", new ArrayList<>() {
            {
                add(id_pays);
                add(lib_pays);
            }
        }, resultSet -> {

        });

        db.disconnect();
    }
}
