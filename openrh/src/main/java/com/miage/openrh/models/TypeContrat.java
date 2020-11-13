package com.miage.openrh.models;


import com.miage.openrh.Database;

import java.sql.SQLException;
import java.util.ArrayList;

public class TypeContrat {
    private Integer id_type_contrat;
    private String lib_contrat;

    public TypeContrat() {

    }

    public Integer getId_type_contrat() {
        return id_type_contrat;
    }

    public void setId_type_contrat(Integer id_type_contrat) {
        this.id_type_contrat = id_type_contrat;
    }

    public String getLib_contrat() {
        return lib_contrat;
    }

    public void setLib_contrat(String lib_contrat) {
        this.lib_contrat = lib_contrat;
    }

    public TypeContrat(Integer id_type_contrat, String lib_contrat) {
        this.id_type_contrat = id_type_contrat;
        this.lib_contrat = lib_contrat;
    }
    public void save() throws SQLException {
        Database db = new Database("root", "", "openrh");

        db.connect();

        db.sendQuery("INSERT INTO typeContrat(id_type_contrat,lib_contrat) VALUES(?,?)", new ArrayList<>() {
            {
                add(id_type_contrat);
                add(lib_contrat);
            }
        }, resultSet -> {

        });

        db.disconnect();
    }
}
