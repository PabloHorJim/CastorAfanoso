package com.backend.service;

import com.backend.api.model.Embalse;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import com.google.gson.Gson;

import javax.net.ssl.HttpsURLConnection;

@Service
public class EmbalseService {
    private static String app_name = "Castores Afanosos";
    private static int year = 2024;

    private static List<Embalse> embalses = new ArrayList<Embalse>();
    private static String enlaceBD = "https://gbdc01ffb7d1854-castoresafanosos.adb.eu-madrid-1.oraclecloudapps.com/ords/castor_afanoso/combined_embalses/" ;

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

    private static double calcularDistancia(String latitudA, String longitudA, String latitudB, String longitudB) {
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

    private HttpsURLConnection getHttpsURLConnection(String url_resource) throws IOException {

        URL service = new URL(url_resource);
        // Create the connection from the URL
        HttpsURLConnection connection = (HttpsURLConnection) service.openConnection();
        // Add the headers User-Agent and Accept (see the statement)
        connection.setRequestProperty("User-Agent", app_name + "-" + year);
        connection.setRequestProperty("Accept", "application/json");
        // Indicate that it is a GET request
        connection.setRequestMethod("GET");
        // Check that the response code received is correct
        int responseCode = connection.getResponseCode();
        if (responseCode < 200 || responseCode >= 300) {
            throw new IOException("Failed trying to access: " + url_resource + "\nHTTP error code : " + responseCode);
        }
        return connection;
    }

    /**
     * This method is a generic method that deserializes the response to the specified class.
     * @param connection The connection to the resource
     * @param tClass The class to which the response will be deserialized (cannot infer the class from T, as it is erased in Runtime)
     * @return The object of type T deserialized from the response
     * @param <T> The type of the object to be deserialized
     * @throws IOException If there is an error deserializing the response
     */
    private <T> T deserializeResponse(HttpsURLConnection connection, Class<T> tClass) throws IOException {
        Gson parser = new Gson();
        InputStream in = connection.getInputStream(); // Get the InputStream from the connection
        return parser.fromJson(new InputStreamReader(in), tClass);
    }

    public <T> T getResource(String urlname, Class<T> tClass) {
        urlname = urlname.replaceAll("http:", "https:");
        try {
            HttpsURLConnection connection = getHttpsURLConnection(urlname);
            return deserializeResponse(connection, tClass);
        } catch (IOException e) {
            //If the resource is not found, the upper level will retry with another resource
            return null;
        }
    }

    private void printEmbalses(List<Embalse> embalses) {
        for (Embalse embalse : embalses) {
            System.out.println(embalse.toString());
        }
    }
}
