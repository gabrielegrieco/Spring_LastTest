package it.euris.academy.aca_esame.repository;

import it.euris.academy.aca_esame.data.model.Proiezione;
import it.euris.academy.aca_esame.repository.projection.sala.CalcolaIncassoSala;
import it.euris.academy.aca_esame.repository.projection.sala.ControlloPostiDisponibili;
import it.euris.academy.aca_esame.repository.projection.sala.SvuotaSala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProiezioneRepository extends JpaRepository<Proiezione, Long> {

    public Proiezione findProiezioneById(@Param("id") Long id);
    public List<Proiezione> findProiezioneByTitolo(@Param("titolo") String titolo);
    public List<Proiezione> findProiezioneByGenere(@Param("genere") String genere);
    public List<Proiezione> findProiezioneByCasaProduttrice(@Param("casaProduttrice") Long casaProduttrice);
    public List<Proiezione> findProiezioneByRegista(@Param("regista") String regista);
    public List<Proiezione> findProiezioneByEtàMinima(@Param("etàMinima") Long etàMinima);

    /*
    @Query()
    qua
    public List<ControlloPostiDisponibili> getControlloPostiDisponibii(@Param("id") Long id);

    @Query(value = "
    ", nativeQuery = true)


    public List<SvuotaSala> getSvuotaSala(@Param("id") Long id);

    @Query(value = "SELECT SUM (aca_esame.biglietto.prezzo) FROM aca_esame.biglietto b
        JOIN aca_esame.spettatore s ON b.id = s.biglietto_id
        JOIN aca_esame.proiezione_sala p_s ON s.sala_id = p_s.s_id
        WHERE p_s.s_id = '1'", nativeQuery = true", nativeQuery = true)
        public List<CalcolaIncassoSala> getCalcolaIncassoSala(@Param("id") Long id);
     */

}
