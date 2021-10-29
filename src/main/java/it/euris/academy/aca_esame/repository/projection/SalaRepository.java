package it.euris.academy.aca_esame.repository.projection;

import it.euris.academy.aca_esame.data.model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SalaRepository extends JpaRepository<Sala, Long> {
    public Sala findSalaById(@Param("id") Long id);
}
