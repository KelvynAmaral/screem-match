package screem.match.api.series.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import screem.match.api.series.model.DadosSerie;


//Serviço de conversão de dados
//Agora que já temos o JSON, precisamos converter para um objeto Java. Para isso, criaremos uma classe que fará essa conversão.

public class ConverteDados implements IConverteDados{
    private ObjectMapper mapper = new ObjectMapper(); //metodo para converter dados genericos usamos quando temos vrios dados para ler e converter
    @Override //sobrescrevendo o metodo obterDados
    public <T> T obterDados(String json, Class<T> classe) {
        try {
        return mapper.readValue(json, classe); //leia o json e converta para classe
        } catch (JsonProcessingException e) {
        throw new RuntimeException("Erro ao converter dados", e);
    }
}
}
