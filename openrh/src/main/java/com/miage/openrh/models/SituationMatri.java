package com.miage.openrh.models;


import com.miage.openrh.Database;

import java.sql.SQLException;
import java.util.ArrayList;

public class SituationMatri {
    private Integer id_sit;
    private String lib_sit;

    public Integer getId_sit() {
        return id_sit;
    }

    public void setId_sit(Integer id_sit) {
        this.id_sit = id_sit;
    }

    public String getLib_sit() {
        return lib_sit;
    }

    public void setLib_sit(String lib_sit) {
        this.lib_sit = lib_sit;
    }

    public SituationMatri(Integer id_sit, String lib_sit) {
        this.id_sit = id_sit;
        this.lib_sit = lib_sit;
    }
    public void save() throws SQLException {
        Database db = new Database("root", "", "openrh");

        db.connect();

        db.sendQuery("INSERT INTO situationMatri (id_sit,lib_sit) VALUES(?,?)", new ArrayList<>() {
            {
                add(id_sit);
                add(lib_sit);
            }
        }, resultSet -> {

        });

        db.disconnect();
    }
}
