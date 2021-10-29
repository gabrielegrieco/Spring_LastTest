package it.euris.academy.aca_esame.repository;

import it.euris.academy.aca_esame.data.model.Spettatore;
import it.euris.academy.aca_esame.data.model.Spettatore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpettatoreRepository extends JpaRepository<Spettatore, Long> {

    public List<Spettatore> findSpettatoreById(@Param("id") Long id);
    public List<Spettatore> findSpettatoreByNome(@Param("nome") String genere);
    public List<Spettatore> findSpettatoreByBigliettoId(@Param("biglietto_id") String bigliettoId);
}
