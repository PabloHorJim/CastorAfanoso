package com.backend.api.model;

public class Embalse {
    String embalse_nombre;
    String ambito_nombre;
    String agua_total;
    String electrico_flag;
    String x;
    String y;
    String cauce;
    String google; //URL
    String openStreetMap; //URL
    String wikiData; //URL
    String provincia;
    String ccaa;
    String tipo;
    String cota_coron;
    String alt_cimien;
    String informe; //URL

    int radio;

    public String getEmbalse_nombre() {
        return embalse_nombre;
    }

    public String getAmbito_nombre() {
        return ambito_nombre;
    }

    public String getAgua_total() {
        return agua_total;
    }

    public String getElectrico_flag() {
        return electrico_flag;
    }

    public String getX() {
        return x;
    }

    public String getY() {
        return y;
    }

    public String getCauce() {
        return cauce;
    }

    public String getGoogle() {
        return google;
    }

    public String getOpenStreetMap() {
        return openStreetMap;
    }

    public String getWikiData() {
        return wikiData;
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
        return cota_coron;
    }

    public String getAlt_cimien() {
        return alt_cimien;
    }

    public String getInforme() {
        return informe;
    }

    public void setEmbalse_nombre(String embalse_nombre) {
        this.embalse_nombre = embalse_nombre;
    }

    public void setAmbito_nombre(String ambito_nombre) {
        this.ambito_nombre = ambito_nombre;
    }

    public void setAgua_total(String agua_total) {
        this.agua_total = agua_total;
    }

    public void setElectrico_flag(String electrico_flag) {
        this.electrico_flag = electrico_flag;
    }

    public void setX(String x) {
        this.x = x;
    }

    public void setY(String y) {
        this.y = y;
    }

    public void setCauce(String cauce) {
        this.cauce = cauce;
    }

    public void setGoogle(String google) {
        this.google = google;
    }

    public void setOpenStreetMap(String openStreetMap) {
        this.openStreetMap = openStreetMap;
    }

    public void setWikiData(String wikiData) {
        this.wikiData = wikiData;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setCcaa(String ccaa) {
        this.ccaa = ccaa;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCota_coron(String cota_coron) {
        this.cota_coron = cota_coron;
    }

    public void setAlt_cimien(String alt_cimien) {
        this.alt_cimien = alt_cimien;
    }

    public void setInforme(String informe) {
        this.informe = informe;
    }

    public Embalse(String x, String y, int radio){
        this.x = x;
        this.y = y;
        this.radio = radio;
    }
}
