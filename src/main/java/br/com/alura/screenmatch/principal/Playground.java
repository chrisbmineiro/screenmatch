package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.models.DadosSerie;
import br.com.alura.screenmatch.services.ConsumoAPI;
import br.com.alura.screenmatch.services.ConverteDados;

import java.util.Scanner;

public class Playground {
    Scanner scanner = new Scanner(System.in);
    ConsumoAPI consumo = new ConsumoAPI();
    ConverteDados conversor = new ConverteDados();

    private final String URL = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=61bb5afd";

    public void exibeMenu() {
        var menu = """
                    1 - Buscar séries
                    2 - Buscar episódios
                                    
                    0 - Sair                                 
                    """;

        System.out.println(menu);
        var opcao = scanner.nextInt();
        scanner.nextLine();
    }

    public void BuscarSerie(){
        System.out.println("Digite o nome da serie: ");
        var nomeSerie = scanner.nextLine();
        var json = consumo.obterDados(URL + nomeSerie.replace(" ", "+") + API_KEY);

        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);

        System.out.println(dados);
    }
    //        List<DadosTemporada> temporadas = new ArrayList<>();
//
//        for (int i = 1; i <= dados.totalTemporadas(); i++ ) {
//            json = consumo.obterDados(URL + nomeSerie.replace(" ", "+") + "&season=" + i + API_KEY);
//            DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
//            temporadas.add(dadosTemporada);
//        }
//        temporadas.forEach(System.out::println);
//
//        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));

//        List<DadosEpisodio> dadosEpisodios = temporadas.stream()
//                .flatMap(t -> t.episodios().stream())
//                .collect(Collectors.toList());
//
//        System.out.println("\nTop 10 episodios: ");
//        dadosEpisodios.stream()
//                .filter(e -> !e.avaliacao().equalsIgnoreCase("N/A"))
//                .peek(e -> System.out.println("Filtrando: " + e))
//                .sorted(Comparator.comparing(DadosEpisodio::avaliacao).reversed())
//                .peek(e -> System.out.println("Ordenando: " + e))
//                .limit(10)
//                .peek(e -> System.out.println("Limitando: " + e))
//                .map(e -> e.titulo().toUpperCase())
//                .peek(e -> System.out.println("Mapeando: " + e))
//                .forEach(System.out::println);
//
//        List<Episodio> episodios = temporadas.stream()
//                .flatMap(t -> t.episodios().stream().map(d -> new Episodio(t.episodio(), d))
//                )
//                .toList();
//
//        episodios.forEach(System.out::println);
//
//        System.out.println("Digite o techo do nome do episodio: ");
//        var buscaEpisodio = scanner.nextLine();
//
//        Optional<Episodio> firstBusca = episodios.stream()
//                .filter(e -> e.getTitulo().toUpperCase().contains(buscaEpisodio.toUpperCase()))
//                .findFirst();
//
//        if (firstBusca.isPresent()){
//            System.out.println("episodio encontrado!");
//            System.out.println("Temporada: " + firstBusca.get().getTemporada());
//        } else {
//            System.out.println("episodio não encotrado!");
//        }
//
//        System.out.println("Digite a partir de que ano você quer: ");
//        int ano = scanner.nextInt();
//        scanner.nextLine();
//
//        LocalDate dataBusca = LocalDate.of(ano, 1,1);
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//        episodios.stream()
//                .filter(e -> e.getDataLancamento() != null && e.getDataLancamento().isAfter(dataBusca))
//                .forEach(e -> System.out.println(
//                        "Temporada: " + e.getTemporada() +
//                                " Episodio: " + e.getTitulo() +
//                                " Data de lançamento: " + e.getDataLancamento().format(formatter)
//                ));
//
//        Map<Integer, Double> avalicacoesTemporada = episodios.stream()
//                .filter(episodio -> episodio.getAvaliacao()> 0.0)
//                .collect(Collectors.groupingBy(Episodio::getTemporada,
//                Collectors.averagingDouble(Episodio::getAvaliacao)));
//        System.out.println(avalicacoesTemporada);
//
//        DoubleSummaryStatistics est = episodios.stream()
//                .filter(episodio -> episodio.getAvaliacao()> 0.0)
//                .collect(Collectors.summarizingDouble(Episodio::getAvaliacao));
//
//        System.out.println("Quantidade: " + est.getCount());
//        System.out.println("Melhor: " + est.getMax());
//        System.out.println("Pior: " + est.getMin());
//        System.out.println("Média: " + est.getAverage());
//
//        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
//        Optional<Integer> result = numbers.stream().reduce(Integer::sum);
//        result.ifPresent(System.out::println); //prints 15
//
//        List<List<String>> list = List.of(
//                List.of("a", "b"),
//                List.of("c", "d")
//        );
//
//        Stream<String> stream = list.stream()
//                .flatMap(Collection::stream);
//
//        stream.forEach(System.out::println);
//
//        Stream.iterate(0, n -> n + 1)
//                .limit(10)
//                .forEach(System.out::println);
}

