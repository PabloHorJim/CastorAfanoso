package com.backend.api.model;

public class Embalse {
    private int id;
    private String ambito_nombre;
    private String embalse_nombre;
    private double agua_total;
    private double electrico_flag;
    private String x;
    private String y;
    private String provincia;
    private String ccaa;
    private String tipo;
    private String cota_coron;
    private String alt_cimien;

    public Embalse(int id, String ambito_nombre, String embalse_nombre, double agua_total, double electrico_flag, String x, String y, String provincia, String ccaa, String tipo, String cota_coron, String alt_cimien) {
        this.id = id;
        this.ambito_nombre = ambito_nombre;
        this.embalse_nombre = embalse_nombre;
        this.agua_total = agua_total;
        this.electrico_flag = electrico_flag;
        this.x = x;
        this.y = y;
        this.provincia = provincia;
        this.ccaa = ccaa;
        this.tipo = tipo;
        this.cota_coron = cota_coron;
        this.alt_cimien = alt_cimien;

    }

    public String getTipo() {
        return tipo;
    }

    public String getCota_coron() {
        return cota_coron;
    }

    public String getAlt_cimien() {
        return alt_cimien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAmbito_nombre() {
        return ambito_nombre;
    }

    public void setAmbito_nombre(String ambito_nombre) {
        this.ambito_nombre = ambito_nombre;
    }

    public String getEmbalse_nombre() {
        return embalse_nombre;
    }

    public void setEmbalse_nombre(String embalse_nombre) {
        this.embalse_nombre = embalse_nombre;
    }

    public double getAgua_total() {
        return agua_total;
    }

    public void setAgua_total(double agua_total) {
        this.agua_total = agua_total;
    }

    public double getElectrico_flag() {
        return electrico_flag;
    }

    public String getX() {
        return x;
    }

    public String getY() {
        return y;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getCcaa() {
        return ccaa;
    }



    public String toString() {
        return "Embalse{" +
                "id=" + id +
                ", ambito_nombre='" + ambito_nombre + '\'' +
                ", embalse_nombre='" + embalse_nombre + '\'' +
                ", agua_total=" + agua_total +
                ", electrico_flag=" + electrico_flag +
                ", x='" + x + '\'' +
                ", y='" + y + '\'' +
                ", provincia='" + provincia + '\'' +
                ", ccaa='" + ccaa + '\'' +
                ", tipo='" + tipo + '\'' +
                ", cota_coron='" + cota_coron + '\'' +
                ", alt_cimien='" + alt_cimien + '\'' +
                '}';
    }


}
