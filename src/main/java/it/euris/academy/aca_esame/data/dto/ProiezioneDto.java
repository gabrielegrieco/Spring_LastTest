package it.euris.academy.aca_esame.data.dto;

import it.euris.academy.aca_esame.data.enums.Genere;

import java.time.Instant;

public class ProiezioneDto {

    private Long id;

    private String titolo;

    private String Regista;

    private String CasaProduttrice;

    private Genere genere;

    private Instant durata;

    private Long etàMinima;
}
