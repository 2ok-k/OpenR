package com.miage.openrh.models;

import com.miage.openrh.Database;

import java.sql.SQLException;
import java.util.ArrayList;

public class Rubrique {
    private Integer id_rub;
    private String lib_rub;

    public Rubrique() {

    }

    public Integer getId_rub() {
        return id_rub;
    }

    public void setId_rub(Integer id_rub) {
        this.id_rub = id_rub;
    }

    public String getLib_rub() {
        return lib_rub;
    }

    public void setLib_rub(String lib_rub) {
        this.lib_rub = lib_rub;
    }

    public Rubrique(Integer id_rub, String lib_rub) {
        this.id_rub = id_rub;
        this.lib_rub = lib_rub;
    }

    public void save() throws SQLException {
        Database db = new Database("root", "", "openrh");

        db.connect();

        db.sendQuery("INSERT INTO rubrique (id_rub,lib_rub) VALUES(?,?)", new ArrayList<>() {
            {
                add(id_rub);
                add(lib_rub);
            }
        }, resultSet -> {

        });

        db.disconnect();
    }
}
