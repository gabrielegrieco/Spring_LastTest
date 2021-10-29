package it.euris.academy.aca_esame.repository;

import it.euris.academy.aca_esame.data.model.Biglietto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BigliettoRepository extends JpaRepository<Biglietto, Long> {

    public Biglietto findBigliettoById(@Param("id") Long id);
    public List<Biglietto> findBigliettoByPostoAssegnato(@Param("postoAssegnato") String postoAssegnato);

}
