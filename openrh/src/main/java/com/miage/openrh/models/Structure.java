package com.miage.openrh.models;

import com.miage.openrh.Database;

import java.sql.SQLException;
import java.util.ArrayList;

public class Structure {
    private Integer cod_struct;
    private String lib_struct;

    public Structure() {

    }

    public Integer getCod_struct() {
        return cod_struct;
    }

    public void setCod_struct(Integer cod_struct) {
        this.cod_struct = cod_struct;
    }

    public String getLib_struct() {
        return lib_struct;
    }

    public void setLib_struct(String lib_struct) {
        this.lib_struct = lib_struct;
    }

    public Structure(Integer cod_struct, String lib_struct) {
        this.cod_struct = cod_struct;
        this.lib_struct = lib_struct;
    }
    public void save() throws SQLException {
        Database db = new Database("root", "", "openrh");

        db.connect();

        db.sendQuery("INSERT INTO structure(cod_struct,lib_struct) VALUES(?,?)", new ArrayList<>() {
            {
                add(cod_struct);
                add(lib_struct);
            }
        }, resultSet -> {

        });

        db.disconnect();
    }
}
