package screem.match.api.series.principal;

import screem.match.api.series.model.DadosEpisodios;
import screem.match.api.series.model.DadosSerie;
import screem.match.api.series.model.DadosTemporada;
import screem.match.api.series.service.ConsumoAPI;
import screem.match.api.series.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private final String ENDERECO = "http://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=8d365641";
    private ConsumoAPI consumo = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();//instancia o conversor

    Scanner sc = new Scanner(System.in);

    public void exibeMenu() {
        System.out.println("Digite o nome da serie");
        var nomeSerie = sc.nextLine();
        var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
        DadosSerie dadosSerie = conversor.obterDados(json, DadosSerie.class);//converte o json para classe DadosSerie
        System.out.println(dadosSerie);

        List<DadosTemporada> temporadas = new ArrayList<>();

        for (int i = 1; i <= dadosSerie.totalTemporadas(); i++) {// percorrendo as temporadas da serie na lista
            json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + i + API_KEY);
            DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
            temporadas.add(dadosTemporada);
        }
//        temporadas.forEach(System.out::println);//imprime as temporadas
        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println("Temporada: " + t.numero() + " Episodio: " + " " + e.titulo())));
    }
}


