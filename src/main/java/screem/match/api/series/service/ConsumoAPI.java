package screem.match.api.series.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {

    public String obterDados(String endereco) {

        HttpClient client = HttpClient.newHttpClient();// Cliente
        HttpRequest request = HttpRequest.newBuilder() //cria uma URI pra dizer qual endereço fazer uma requisição / requisição
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = null; //define o formato da requisição tipo String
        try {
            response = client //envia a chamada
                    .send(request, HttpResponse.BodyHandlers.ofString()); //chamada em curso
        } catch (IOException e) {   //trata algum erro ou excessão
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String json = response.body();
        return json; //corpo da resposta
    }
}
