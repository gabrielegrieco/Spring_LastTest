package it.euris.academy.aca_esame.controller;

import it.euris.academy.aca_esame.data.dto.BigliettoDto;
import it.euris.academy.aca_esame.service.BigliettoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/biglietto")
@ResponseStatus(HttpStatus.CREATED)
public class BigliettoController {
    @Autowired
    BigliettoService bigliettoService;

    @GetMapping("/v1")
    public List<BigliettoDto> getAll(){
        return bigliettoService.getAll();
    }

    @GetMapping("/v1/{id}")
    public BigliettoDto getById(@PathVariable("id") Long id) {
        return bigliettoService.get(id);
    }
    @DeleteMapping("/v1/{id}")
    public Boolean delete(@PathVariable("id") Long id) {
        return bigliettoService.delete(id);
    }

    @PutMapping
    public BigliettoDto update(@RequestBody BigliettoDto bigliettoDto) {
        return bigliettoService.update(bigliettoDto);
    }

    @PatchMapping("/v1")
    public BigliettoDto patch(@RequestBody BigliettoDto bigliettoDto) {
        return bigliettoService.update(bigliettoDto);
    }

    @PostMapping("/v1")
    public BigliettoDto insert(@RequestBody BigliettoDto bigliettoDto) {
        return bigliettoService.insert(bigliettoDto);
    }
    
}
