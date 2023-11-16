package screem.match.api.series.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) //Ignorar propriedades desconhecidas ou não mapeadas em JSON
public record DadosEpisodios(@JsonAlias ("Title") String titulo,
                             @JsonAlias ("Episode") Integer episodio,
                             @JsonAlias ("imdbRating") String avaliacao,
                             @JsonAlias ("Released") String dataLancamento   ) {

}
