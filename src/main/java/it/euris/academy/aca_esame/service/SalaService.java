package it.euris.academy.aca_esame.service;

import it.euris.academy.aca_esame.data.dto.SalaDto;

import java.util.List;

public interface SalaService {

    public List<SalaDto> getAll();
    public SalaDto get(Long id);
    public SalaDto insert(SalaDto salaDto);
    public SalaDto update(SalaDto salaDto);
    public Boolean delete(Long id);
}
