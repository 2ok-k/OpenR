package com.miage.openrh.models;

import com.miage.openrh.Database;

import java.sql.SQLException;
import java.util.ArrayList;

public class GroupeUtilisateur {
    private Integer id_grpUt;
    private String lib_grpUt;

    public Integer getId_grpUt() {
        return id_grpUt;
    }

    public void setId_grpUt(Integer id_grpUt) {
        this.id_grpUt = id_grpUt;
    }

    public String getLib_grpUt() {
        return lib_grpUt;
    }

    public void setLib_grpUt(String lib_grpUt) {
        this.lib_grpUt = lib_grpUt;
    }

    public GroupeUtilisateur(Integer id_grpUt, String lib_grpUt) {
        this.id_grpUt = id_grpUt;
        this.lib_grpUt = lib_grpUt;
    }
    public void save() throws SQLException {
        Database db = new Database("root", "", "openrh");

        db.connect();

        db.sendQuery("INSERT INTO groupeUtilisateur(id_grpUt,lib_grpUt) VALUES(?,?)", new ArrayList<>() {
            {
                add(id_grpUt);
                add(lib_grpUt);
            }
        }, resultSet -> {

        });

        db.disconnect();
    }
}
