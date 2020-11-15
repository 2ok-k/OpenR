package com.miage.openrh.models;

public class Login {
    private String mat_emp;
    private String password;

    public String getMat_emp() {
        return mat_emp;
    }

    public void setMat_emp(String mat_emp) {
        this.mat_emp = mat_emp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Login(String mat_emp, String password) {
        this.mat_emp = mat_emp;
        this.password = password;
    }
}
