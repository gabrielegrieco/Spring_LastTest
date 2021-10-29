package it.euris.academy.aca_esame.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.academy.aca_esame.data.archetype.Dto;
import it.euris.academy.aca_esame.data.archetype.Model;
import it.euris.academy.aca_esame.data.model.Biglietto;
import it.euris.academy.aca_esame.data.model.Sala;
import it.euris.academy.aca_esame.data.model.Spettatore;
import it.euris.academy.aca_esame.utils.UT;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SpettatoreDto implements Dto {

    private String id;

    private String nome;

    private String nascita;

    private String bigliettoId;

    private String salaId;

    public String cancellato;

    @Override
    public Spettatore toModel() {
        return Spettatore.builder()
                .id(UT.toLong(id))
                .nome(nome)
                .nascita(UT.toInstant(nascita))
                .biglietto(new Biglietto(bigliettoId))
                .cancellato(Boolean.valueOf(cancellato))
                .sala(new Sala(salaId))
                .build();
    }
}
