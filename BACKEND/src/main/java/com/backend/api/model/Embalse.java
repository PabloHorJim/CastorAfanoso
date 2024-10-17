package com.backend.api.model;

public class Embalse {
    private int id;
    private String ambitoNombre;
    private String embalseNombre;
    private double aguaTotal;
    private double electricoFlag;
    private String x;
    private String y;
    private String provincia;
    private String ccaa;
    private String tipo;
    private String cotaCoron;
    private String altCimien;

    public Embalse(int id, String ambitoNombre, String embalseNombre, double aguaTotal, double electricoFlag, String x, String y, String provincia, String ccaa, String tipo, String cotaCoron, String altCimien) {
        this.id = id;
        this.ambitoNombre = ambitoNombre;
        this.embalseNombre = embalseNombre;
        this.aguaTotal = aguaTotal;
        this.electricoFlag = electricoFlag;
        this.x = x;
        this.y = y;
        this.provincia = provincia;
        this.ccaa = ccaa;
        this.tipo = tipo;
        this.cotaCoron = cotaCoron;
        this.altCimien = altCimien;
    }

    public int getId() {
        return id;
    }

    public String getAmbito_nombre() {
        return ambitoNombre;
    }

    public String getEmbalse_nombre() {
        return embalseNombre;
    }

    public double getAgua_total() {
        return aguaTotal;
    }

    public double isElectrico_flag() {
        return electricoFlag;
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

    public String getTipo() {
        return tipo;
    }

    public String getCota_coron() {
        return cotaCoron;
    }

    public String getAlt_cimien() {
        return altCimien;
    }

    public String toString(){
        return "Embalse: " + embalseNombre + " - " + aguaTotal + " - " + x + " - " + y;
    }
}
