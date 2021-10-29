package it.euris.academy.aca_esame.service.impl;

import it.euris.academy.aca_esame.data.dto.CinemaDto;
import it.euris.academy.aca_esame.data.model.Cinema;
import it.euris.academy.aca_esame.repository.CinemaRepository;
import it.euris.academy.aca_esame.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CinemaServiceImpl implements CinemaService {


    @Autowired
    private CinemaRepository cinemaRepository;

    @Override
    public List<CinemaDto> getAll() {
        return cinemaRepository.findAll().stream().map(Cinema::toDto).collect(Collectors.toList());
    }

    @Override
    public CinemaDto get(Long id) {
        Optional<Cinema> cinema = cinemaRepository.findById(id);
        return cinema.isPresent() ? cinema.get().toDto() : null;
    }

    @Override
    public CinemaDto insert(CinemaDto cinemaDto) {
        if(cinemaDto.getId() != null)
            throw new RuntimeException();
        return cinemaRepository.save(cinemaDto.toModel()).toDto();
    }

    @Override
    public CinemaDto update(CinemaDto cinemaDto) {
        if(cinemaDto.getId() == null)
            throw new RuntimeException();
        return cinemaRepository.save(cinemaDto.toModel()).toDto();
    }

    @Override
    public Boolean delete(Long id) {
        cinemaRepository.deleteById(id);
        return cinemaRepository.findById(id).isEmpty();
    }
}
