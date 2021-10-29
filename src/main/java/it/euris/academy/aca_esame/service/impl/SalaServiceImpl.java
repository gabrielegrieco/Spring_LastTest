package it.euris.academy.aca_esame.service.impl;

import it.euris.academy.aca_esame.data.dto.SalaDto;
import it.euris.academy.aca_esame.data.model.Sala;
import it.euris.academy.aca_esame.repository.projection.SalaRepository;
import it.euris.academy.aca_esame.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SalaServiceImpl implements SalaService {

    @Autowired
    private SalaRepository salaRepository;

    @Override
    public List<SalaDto> getAll() {
        return salaRepository.findAll().stream().map(Sala::toDto).collect(Collectors.toList());
    }

    @Override
    public SalaDto get(Long id) {
        Optional<Sala> Sala = salaRepository.findById(id);
        return Sala.isPresent() ? Sala.get().toDto() : null;
    }

    @Override
    public SalaDto insert(SalaDto salaDto) {
        if(salaDto.getId() != null)
            throw new RuntimeException();
        return salaRepository.save(salaDto.toModel()).toDto();
    }

    @Override
    public SalaDto update(SalaDto SalaDto) {
        if(SalaDto.getId() == null)
            throw new RuntimeException();
        return salaRepository.save(SalaDto.toModel()).toDto();
    }

    @Override
    public Boolean delete(Long id) {
        salaRepository.deleteById(id);
        return salaRepository.findById(id).isEmpty();
    }
}
