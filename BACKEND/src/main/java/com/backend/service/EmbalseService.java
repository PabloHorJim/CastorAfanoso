package com.backend.service;

import com.backend.api.model.Embalse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EmbalseService {

    private List<Embalse> embalses = new ArrayList<Embalse>();
    private static String enlaceBD = "" ;

    public EmbalseService() {

        //double distancia = calcularDistancia();
    }

    public static double calcularDistancia(double latitudA, double longitudA, double latitudB, double longitudB) {
        final int R = 6371; // Radio de la Tierra en km

        // Conversión a radianes
        double latA = Math.toRadians(latitudA);
        double longA = Math.toRadians(longitudA);
        double latB = Math.toRadians(latitudB);
        double longB = Math.toRadians(longitudB);

        // Fórmula de Haversine
        double dLat = latB - latA;
        double dLong = longB - longA;

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(latA) * Math.cos(latB) *
                        Math.sin(dLong / 2) * Math.sin(dLong / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return R * c; // Distancia en km
    }
    public List<Embalse> getFromDist(String lat, String lon, String dist) {
        List<Embalse> embalses = new LinkedList<>();
        return embalses;
    }
}
