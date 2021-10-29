package it.euris.academy.aca_esame.service;

import it.euris.academy.aca_esame.data.dto.CinemaDto;

import java.util.List;

public interface CinemaService {

    public List<CinemaDto> getAll();
    public CinemaDto get(Long id);
    public CinemaDto insert(CinemaDto cinemaDto);
    public CinemaDto update(CinemaDto cinemaDto);
    public Boolean delete(Long id);


}
