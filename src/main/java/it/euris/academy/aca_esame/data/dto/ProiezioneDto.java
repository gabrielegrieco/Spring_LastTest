package it.euris.academy.aca_esame.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.academy.aca_esame.data.archetype.Dto;
import it.euris.academy.aca_esame.data.archetype.Model;
import it.euris.academy.aca_esame.data.enums.Genere;
import it.euris.academy.aca_esame.data.model.Proiezione;
import it.euris.academy.aca_esame.data.model.Sala;
import it.euris.academy.aca_esame.utils.UT;
import lombok.*;

import java.time.Instant;
import java.util.Set;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProiezioneDto implements Dto {

    private String id;

    private String titolo;

    private String regista;

    private String casaProduttrice;

    private String genere;

    private String durata;

    private String etàMinima;

    private String cancellato;

    @JsonIgnore
    private Set<Sala> sale;

    @Override
    public Proiezione toModel() {
        return Proiezione.builder()
                .id(UT.toLong(id))
                .titolo(titolo)
                .genere(UT.getGenere(genere))
                .regista(regista)
                .casaProduttrice(casaProduttrice)
                .durata(UT.toLong(durata))
                .etàMinima(UT.toLong(etàMinima))
                .cancellato(Boolean.valueOf(cancellato))
                .build();
    }
}
