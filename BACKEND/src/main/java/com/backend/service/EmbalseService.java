package com.backend.service;

import com.backend.api.model.Embalse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class EmbalseService {

    private static List<Embalse> embalses = new ArrayList<Embalse>();
    private static String enlaceBD = "" ;

    public EmbalseService() {
        Embalse aux = new Embalse(3,
                "GUADALQUIVIR",
                "FERNANDINA, LA",
                247,
                false,
                "38,179645624",
                "-3,57022439999997",
                "Jaén",
                "Andalucía",
                "Presa de fábrica de gravedad (hormigón vibrado)",
                null,
                null);
        embalses.add(aux);
    }

    private static double calcularDistancia(double latitudA, double longitudA, double latitudB, double longitudB) {
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

    public static double calcularDistancia(String latitudA, String longitudA, String latitudB, String longitudB) {
        try {
            // Reemplazar coma por punto
            latitudA = latitudA.replace(",", ".");
            longitudA = longitudA.replace(",", ".");
            latitudB = latitudB.replace(",", ".");
            longitudB = longitudB.replace(",", ".");

            // Convertir a double
            double latitudADouble = Double.parseDouble(latitudA);
            double longitudADouble = Double.parseDouble(longitudA);
            double latitudBDouble = Double.parseDouble(latitudB);
            double longitudBDouble = Double.parseDouble(longitudB);

            return calcularDistancia(latitudADouble, longitudADouble, latitudBDouble, longitudBDouble);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static List<Embalse> getFromDist(String lat, String lon, Integer distancia) {
        List<Embalse> embalsesAux = new LinkedList<>();
        for (Embalse embalse : embalses) {
            double distCalculada = calcularDistancia(embalse.getX(), embalse.getY(), lat, lon);
            if ((distCalculada > 0) && (distCalculada < distancia))
                embalsesAux.add(embalse);
        }
        return embalsesAux;
    }
}
