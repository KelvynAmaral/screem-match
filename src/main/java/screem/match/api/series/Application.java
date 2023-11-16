package screem.match.api.series;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import screem.match.api.series.principal.Principal;

@SpringBootApplication
public class Application implements CommandLineRunner {//Essa interface permitirá realizar algumas chamadas no método principal.

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	//Quando uma interface é implementada, temos um contrato. Portanto, preciso implementar os métodos ainda não implementados, que nesse caso, é o run.

	@Override
	public void run(String... args) throws Exception {//Quando o método run é implementado, o que o código indica que quando o public static void main chamar o SpringApplication.run, ele invocará esse método run que estamos implementando.
		Principal principal = new Principal();
		principal.exibeMenu();
	}
}