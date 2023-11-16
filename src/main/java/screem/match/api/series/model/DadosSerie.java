package screem.match.api.series.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


//dissearilizando json para objeto java
//Usaremos a biblioteca Jackson para fazer a conversão de JSON para objeto Java.
//record para ter o cabeçalho do metodo obterDados
@JsonIgnoreProperties(ignoreUnknown = true) //Ignorar propriedades desconhecidas ou não mapeadas em JSON
public record DadosSerie (
        @JsonAlias("Title")
        String titulo,
        @JsonAlias("totalSeasons")
        Integer totalTemporadas,
        @JsonAlias("imdbRating")
        String avaliacao) {
      //jsonAlias é uma anotação que indica que o atributo da classe é um alias "Apelido" para o nome do campo JSON.
      //mapeamos o json para classe java
}
