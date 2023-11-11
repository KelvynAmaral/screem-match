package screem.match.api.series;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import screem.match.api.series.model.DadosSerie;
import screem.match.api.series.service.ConsumoAPI;
import screem.match.api.series.service.ConverteDados;

@SpringBootApplication
public class Application implements CommandLineRunner {//Essa interface permitirá realizar algumas chamadas no método principal.

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	//Quando uma interface é implementada, temos um contrato. Portanto, preciso implementar os métodos ainda não implementados, que nesse caso, é o run.

	@Override
	public void run(String... args) throws Exception {//Quando o método run é implementado, o que o código indica que quando o public static void main chamar o SpringApplication.run, ele invocará esse método run que estamos implementando.
		var consumoAPI = new ConsumoAPI(); //obtenho os dados da api
		//var = json - variavel json recebe o consumoAPI.obterDados
		var json = consumoAPI.obterDados("http://www.omdbapi.com/?t=gilmore%2Bgirls&apikey=8d365641");
		System.out.println(json);//imprime o json para confirmar
		ConverteDados conversor	= new ConverteDados();//instancia o conversor
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);//converte o json para classe DadosSerie
		System.out.println(dados);
	}
}
