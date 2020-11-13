package com.miage.openrh.models;

import com.miage.openrh.Database;

import java.sql.SQLException;
import java.util.ArrayList;

public class Genre {
    private Integer id_genre;
    private String lib_genre;

    public Genre() {

    }

    public Integer getId_genre() {
        return id_genre;
    }

    public void setId_genre(Integer id_genre) {
        this.id_genre = id_genre;
    }

    public String getLib_genre() {
        return lib_genre;
    }

    public void setLib_genre(String lib_genre) {
        this.lib_genre = lib_genre;
    }

    public Genre(Integer id_genre, String lib_genre) {
        this.id_genre = id_genre;
        this.lib_genre = lib_genre;
    }

    public void save() throws SQLException {
        Database db = new Database("root", "", "openrh");

        db.connect();

        db.sendQuery("INSERT INTO genre (id_genre,lib_genre) VALUES(?,?)", new ArrayList<>() {
            {
                add(id_genre);
                add(lib_genre);
            }
        }, resultSet -> {

        });

        db.disconnect();
    }
}
