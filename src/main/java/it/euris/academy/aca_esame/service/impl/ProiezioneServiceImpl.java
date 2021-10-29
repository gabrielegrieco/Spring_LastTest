package it.euris.academy.aca_esame.service.impl;

import it.euris.academy.aca_esame.data.dto.ProiezioneDto;
import it.euris.academy.aca_esame.data.model.Proiezione;
import it.euris.academy.aca_esame.repository.ProiezioneRepository;
import it.euris.academy.aca_esame.service.ProiezioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProiezioneServiceImpl implements ProiezioneService {

    @Autowired
    private ProiezioneRepository proiezioneRepository;

    @Override
    public List<ProiezioneDto> getAll() {
        return proiezioneRepository.findAll().stream().map(Proiezione::toDto).collect(Collectors.toList());
    }

    @Override
    public ProiezioneDto get(Long id) {
        Optional<Proiezione> proiezione = proiezioneRepository.findById(id);
        return proiezione.isPresent() ? proiezione.get().toDto() : null;
    }

    @Override
    public ProiezioneDto insert(ProiezioneDto proiezioneDto) {
        if(proiezioneDto.getId() != null)
            throw new RuntimeException();
        return proiezioneRepository.save(proiezioneDto.toModel()).toDto();
    }

    @Override
    public ProiezioneDto update(ProiezioneDto proiezioneDto) {
        if(proiezioneDto.getId() == null)
            throw new RuntimeException();
        return proiezioneRepository.save(proiezioneDto.toModel()).toDto();
    }

    @Override
    public Boolean delete(Long id) {
        proiezioneRepository.deleteById(id);
        return proiezioneRepository.findById(id).isEmpty();
    }
}
