package com.miage.openrh.models;

import com.miage.openrh.Database;

import java.sql.SQLException;
import java.util.ArrayList;

public class Secteur {
    private Integer id_sect;
    private String lib_sect;

    public Integer getId_sect() {
        return id_sect;
    }

    public void setId_sect(Integer id_sect) {
        this.id_sect = id_sect;
    }

    public String getLib_sect() {
        return lib_sect;
    }

    public void setLib_sect(String lib_sect) {
        this.lib_sect = lib_sect;
    }

    public Secteur(Integer id_sect, String lib_sect) {
        this.id_sect = id_sect;
        this.lib_sect = lib_sect;
    }
    public void save() throws SQLException {
        Database db = new Database("root", "", "openrh");

        db.connect();

        db.sendQuery("INSERT INTO secteur (id_sect,lib_sect) VALUES(?,?)", new ArrayList<>() {
            {
                add(id_sect);
                add(lib_sect);
            }
        }, resultSet -> {

        });

        db.disconnect();
    }
}
