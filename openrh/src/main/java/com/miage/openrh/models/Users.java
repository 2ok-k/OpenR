package com.miage.openrh.models;

import com.miage.openrh.Database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class Users {
    private String groupe_util;
    private String matricule;
    private String password;

    public Users() {

    }

    public String getGroupe_util() {
        return groupe_util;
    }

    public void setGroupe_util(String groupe_util) {
        this.groupe_util = groupe_util;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Users(String groupe_util, String matricule, String password) {
        this.groupe_util = groupe_util;
        this.matricule = matricule;
        this.password = password;
    }

    public void save() throws SQLException {
        Database db = new Database("root", "", "openrh");

        db.connect();

        db.sendQuery("INSERT INTO users(groupe_util,matricule,password) VALUES(?,?,?)", new ArrayList<>() {
            {
                add(groupe_util);
                add(matricule);
                add(password);
            }
        }, resultSet -> {

        });

        db.disconnect();
    }

    public boolean exist() {
        Database db = new Database("root", "", "gth");

        db.connect();

        AtomicBoolean exist = new AtomicBoolean(false);


        try {
            db.sendQuery("SELECT * FROM users WHERE matricule=? AND password=?", new ArrayList<>() {
                {
                    add(matricule);
                    add(password);
                }
            }, resultSet -> {
                if (resultSet.next()) {
                    exist.set(true);
                }
            });
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        db.disconnect();

        return exist.get();
    }
}
