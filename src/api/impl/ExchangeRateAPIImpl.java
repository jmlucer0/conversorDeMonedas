package api.impl;

import api.IExchangeRateAPI;
import com.google.gson.Gson;
import models.TasaDeCambio;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateAPIImpl implements IExchangeRateAPI {

    @Override
    public TasaDeCambio buscarTasaDeCambio(String monedaDeEntrada) {
        //apikey de exchangerate-api.
        String apiKey = "a91320f887f9cadd4c7224a8";
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + monedaDeEntrada);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try{
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            TasaDeCambio tasaDeCambio = new Gson().fromJson(response.body(), TasaDeCambio.class);
            return tasaDeCambio;
        }catch (RuntimeException | IOException | InterruptedException e){
            throw new RuntimeException("No se encontro el tipo de Moneda.");
        }
    }


}
