package it.euris.academy.aca_esame.TestSupport;

import it.euris.academy.aca_esame.data.enums.Genere;
import it.euris.academy.aca_esame.data.model.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestingSupport {

    /* cinema */
    public static Cinema createCinema(Long id) {
        return Cinema.builder()
                .cancellato(Boolean.FALSE)
                .id(id).build();
    }
    public static List<Cinema> createCinemaList(){
        return List.of(createCinema(1L), createCinema(2L));
    }

    /* spettatore */
    public static Spettatore createSpettatore(Long id) {
        var Sala = new Sala();
        var biglietto = new Biglietto();

        return Spettatore.builder()
                .sala(Sala)
                .biglietto(biglietto)
                .cancellato(Boolean.FALSE)
                .nascita(Instant.MIN)
                .nome("")
                .id(id).build();

    }
    public static List<Spettatore> createSpettatoreList(){
        return List.of(createSpettatore(1L), createSpettatore(2L));
    }

    /* biglietto  */
    public static Biglietto createBiglietto(Long id) {

        return Biglietto.builder()
                .postoAssegnato("")
                .cancellato(Boolean.FALSE)
                .prezzo(12.02)
                .id(id).build();

    }
    public static List<Biglietto> createBigliettoList(){
        return List.of(createBiglietto(1L), createBiglietto(2L));
    }

    /* proiezione */
    public static Proiezione createProiezione(Long id) {

        Set<Sala> sale = new HashSet<>();
        return Proiezione.builder()
                .id(id)
                .etàMinima(18l)
                .durata(120l)
                .casaProduttrice("")
                .regista("")
                .genere(Genere.FANTASY)
                .titolo("")
                .sale(sale)
                .build();

    }
    public static List<Proiezione> createProiezioneList(){
        return List.of(createProiezione(1L), createProiezione(2L));
    }

    /* Sala */

    public static Sala createSala(Long id) {

        Set<Proiezione> proiezioni = new HashSet<>();
        return Sala.builder()
                .id(id)
                .cinema(createCinema(1l))
                .postiASedere(55l)
                .cancellato(Boolean.FALSE)
                .proiezioni(proiezioni)
                .spettatori(createSpettatoreList())
                .build();

    }
    public static List<Sala> createSalaList(){
        return List.of(createSala(1L), createSala(2L));
    }
}
