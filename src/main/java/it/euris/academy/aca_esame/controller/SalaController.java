package it.euris.academy.aca_esame.controller;

import it.euris.academy.aca_esame.data.dto.SalaDto;
import it.euris.academy.aca_esame.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sala")
@ResponseStatus(HttpStatus.CREATED)
public class SalaController {
    @Autowired
    SalaService salaService;

    @GetMapping("/v1")
    public List<SalaDto> getAll(){
        return salaService.getAll();
    }

    @GetMapping("/v1/{id}")
    public SalaDto getById(@PathVariable("id") Long id) {
        return salaService.get(id);
    }
    @DeleteMapping("/v1/{id}")
    public Boolean delete(@PathVariable("id") Long id) {
        return salaService.delete(id);
    }

    @PutMapping
    public SalaDto update(@RequestBody SalaDto salaDto) {
        return salaService.update(salaDto);
    }

    @PatchMapping("/v1")
    public SalaDto patch(@RequestBody SalaDto salaDto) {
        return salaService.update(salaDto);
    }

    @PostMapping("/v1")
    public SalaDto insert(@RequestBody SalaDto salaDto) {
        return salaService.insert(salaDto);
    }
    
}
