package it.euris.academy.aca_esame.service.impl;

import it.euris.academy.aca_esame.data.dto.BigliettoDto;
import it.euris.academy.aca_esame.data.model.Biglietto;
import it.euris.academy.aca_esame.repository.BigliettoRepository;
import it.euris.academy.aca_esame.service.BigliettoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BigliettoServiceImpl implements BigliettoService {

    @Autowired
    private BigliettoRepository bigliettoRepository;

    @Override
    public List<BigliettoDto> getAll() {
        return bigliettoRepository.findAll().stream().map(Biglietto::toDto).collect(Collectors.toList());
    }

    @Override
    public BigliettoDto get(Long id) {
        Optional<Biglietto> biglietto = bigliettoRepository.findById(id);
        return biglietto.isPresent() ? biglietto.get().toDto() : null;
    }

    @Override
    public BigliettoDto insert(BigliettoDto bigliettoDto) {
        if(bigliettoDto.getId() != null)
            throw new RuntimeException();
        return bigliettoRepository.save(bigliettoDto.toModel()).toDto();
    }

    @Override
    public BigliettoDto update(BigliettoDto bigliettoDto) {
        if(bigliettoDto.getId() == null)
            throw new RuntimeException();
        return bigliettoRepository.save(bigliettoDto.toModel()).toDto();
    }

    @Override
    public Boolean delete(Long id) {
        bigliettoRepository.deleteById(id);
        return bigliettoRepository.findById(id).isEmpty();
    }
}
