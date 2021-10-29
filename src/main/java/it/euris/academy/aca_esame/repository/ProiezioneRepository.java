package it.euris.academy.aca_esame.repository;

import it.euris.academy.aca_esame.data.model.Proiezione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProiezioneRepository extends JpaRepository<Proiezione, Long> {

    public Proiezione findProiezioneById(@Param("id") Long id);
    public List<Proiezione> findProiezioneByTitolo(@Param("titolo") String titolo);
    public List<Proiezione> findProiezioneByGenere(@Param("genere") String genere);
    public List<Proiezione> findProiezioneByCasaProduttrice(@Param("casaProduttrice") Long casaProduttrice);
    public List<Proiezione> findProiezioneByRegista(@Param("regista") String regista);
    public List<Proiezione> findProiezioneByEtàMinima(@Param("etàMinima") Long etàMinima);
}
