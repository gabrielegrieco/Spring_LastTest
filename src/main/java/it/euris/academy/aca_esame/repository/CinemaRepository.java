package it.euris.academy.aca_esame.repository;

import it.euris.academy.aca_esame.data.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {

    public Cinema findCinemaById(@Param("id") Long id);
}
