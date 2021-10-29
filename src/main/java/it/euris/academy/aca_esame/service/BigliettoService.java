package it.euris.academy.aca_esame.service;

import it.euris.academy.aca_esame.data.dto.BigliettoDto;

import java.util.List;

public interface BigliettoService {

    public List<BigliettoDto> getAll();
    public BigliettoDto get(Long id);
    public BigliettoDto insert(BigliettoDto bigliettoDto);
    public BigliettoDto update(BigliettoDto bigliettoDto);
    public Boolean delete(Long id);
}
