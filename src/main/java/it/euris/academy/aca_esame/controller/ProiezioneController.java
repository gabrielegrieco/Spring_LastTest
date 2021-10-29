package it.euris.academy.aca_esame.controller;

import it.euris.academy.aca_esame.data.dto.ProiezioneDto;
import it.euris.academy.aca_esame.service.ProiezioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proiezione")
@ResponseStatus(HttpStatus.CREATED)
public class ProiezioneController {
    @Autowired
    ProiezioneService proiezioneService;

    @GetMapping("/v1")
    public List<ProiezioneDto> getAll(){
        return proiezioneService.getAll();
    }

    @GetMapping("/v1/{id}")
    public ProiezioneDto getById(@PathVariable("id") Long id) {
        return proiezioneService.get(id);
    }
    @DeleteMapping("/v1/{id}")
    public Boolean delete(@PathVariable("id") Long id) {
        return proiezioneService.delete(id);
    }

    @PutMapping
    public ProiezioneDto update(@RequestBody ProiezioneDto proiezioneDto) {
        return proiezioneService.update(proiezioneDto);
    }

    @PatchMapping("/v1")
    public ProiezioneDto patch(@RequestBody ProiezioneDto proiezioneDto) {
        return proiezioneService.update(proiezioneDto);
    }

    @PostMapping("/v1")
    public ProiezioneDto insert(@RequestBody ProiezioneDto proiezioneDto) {
        return proiezioneService.insert(proiezioneDto);
    }
    
}
