package it.euris.academy.aca_esame.service;

import it.euris.academy.aca_esame.data.dto.ProiezioneDto;

import java.util.List;

public interface ProiezioneService {

    public List<ProiezioneDto> getAll();
    public ProiezioneDto get(Long id);
    public ProiezioneDto insert(ProiezioneDto proiezioneDto);
    public ProiezioneDto update(ProiezioneDto proiezioneDto);
    public Boolean delete(Long id);

    /*
    public List<ProiezioneDto> getProiezioneByTitolo(String title);
    public List<ProiezioneDto> getProiezioneByGenere(String genere);
    public List<ProiezioneDto> getProiezioneByRegista(String regista);
    public List<ProiezioneDto> getProiezioneByCasaProduttrice(String casaProduttrice);
    public List<ProiezioneDto> getProiezioneByEtàMinima(Long etàMinima);
    */
}
