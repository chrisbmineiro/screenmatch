package br.com.alura.screenmatch.repository;

import br.com.alura.screenmatch.models.Categoria;
import br.com.alura.screenmatch.models.Episodio;
import br.com.alura.screenmatch.models.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SerieRepository extends JpaRepository<Serie, Long> {
    Optional<Serie> findByTituloContainingIgnoreCase(String nomeSerie);

    List<Serie> findByAtoresContainingIgnoreCaseAndAvaliacaoGreaterThanEqual(String nomeAtor, Double avaliacao);

    List<Serie> findTop5ByOrderByAvaliacaoDesc();

    List<Serie> findByGenero(Categoria categoria);

    // Primeira opção derived queries
    List<Serie> findByTotalTemporadasLessThanEqualAndAvaliacaoGreaterThanEqual(Integer totalTemporadas, Double avaliacao);

    // Segunda opção JPQL
    @Query("select s from Serie s where s.totalTemporadas <= :totalTemporadas and s.avaliacao >= :avaliacao")
    List<Serie> seriesPorTemporadaEAvaliacao(Integer totalTemporadas, Double avaliacao);

    @Query("select e from Serie s join s.episodios e where e.titulo ilike %:trechoEpisodio%")
    List<Episodio> episodiosPorTrecho(String trechoEpisodio);
}
