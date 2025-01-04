import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaTasas {
    public TasasDeCambio obtenerTasas(String moneda) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/419d96d510fe735eafab4f5c/latest/"+moneda);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), TasasDeCambio.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("No se pudo obtener las tasas de cambio.", e);
        }
    }
}

