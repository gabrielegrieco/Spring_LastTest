package it.euris.academy.aca_esame.service.impl;

import it.euris.academy.aca_esame.data.dto.SpettatoreDto;
import it.euris.academy.aca_esame.data.model.Spettatore;
import it.euris.academy.aca_esame.repository.SpettatoreRepository;
import it.euris.academy.aca_esame.service.SpettatoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SpettatoreServiceImpl implements SpettatoreService {


    @Autowired
    private SpettatoreRepository spettatoreRepository;

    @Override
    public List<SpettatoreDto> getAll() {
        return spettatoreRepository.findAll().stream().map(Spettatore::toDto).collect(Collectors.toList());
    }

    @Override
    public SpettatoreDto get(Long id) {
        Optional<Spettatore> spettatore = spettatoreRepository.findById(id);
        return spettatore.isPresent() ? spettatore.get().toDto() : null;
    }

    @Override
    public SpettatoreDto insert(SpettatoreDto SpettatoreDto) {
        if(SpettatoreDto.getId() != null)
            throw new RuntimeException();
        return spettatoreRepository.save(SpettatoreDto.toModel()).toDto();
    }

    @Override
    public SpettatoreDto update(SpettatoreDto spettatoreDto) {
        if(spettatoreDto.getId() == null)
            throw new RuntimeException();
        return spettatoreRepository.save(spettatoreDto.toModel()).toDto();
    }

    @Override
    public Boolean delete(Long id) {
        spettatoreRepository.deleteById(id);
        return spettatoreRepository.findById(id).isEmpty();
    }
}
