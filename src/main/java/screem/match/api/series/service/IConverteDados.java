package screem.match.api.series.service;


//interface com cabeçalho do metodo obterDados
//recebe o json e uma classe e no conversor tentar converter os dados
public interface IConverteDados {

    <T> T obterDados(String json, Class<T> classe);//metodo generico para converter dados

}
