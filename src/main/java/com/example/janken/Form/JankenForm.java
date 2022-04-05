package com.example.janken.Form;

public class JankenForm {
    private String janken;

    public String getJanken() {
        return janken;
    }

    public void setJanken(String janken) {
        this.janken = janken;
    }

    @Override
    public String toString() {
        return "JankenForm [janken=" + janken + "]";
    }

}