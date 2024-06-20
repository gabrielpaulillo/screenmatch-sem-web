package br.com.alura.screenmatch.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {
//    classe específica de consumo de API
//    vantagem de se criar uma dessas, específica de consumir API, é que não importa a API, a classe está pronta
//    conseguirá buscar a informação e "devolver" o json

//    é bom sempre pensar nessa boa prática de separação de responsabilidades

    public String obterDados(String endereco) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco)) // diz para qual endereço fazer a requisição
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String json = response.body(); // atribuição à variável 'json' o corpo da resposta à requisição feita anteriormente
        return json;
    }
}
