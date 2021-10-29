package it.euris.academy.aca_esame.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.academy.aca_esame.data.archetype.Dto;
import it.euris.academy.aca_esame.data.archetype.Model;
import it.euris.academy.aca_esame.data.model.Biglietto;
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
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "spettore")
@SQLDelete(sql = "UPDATE spettore SET deleted = true WHERE id=? ")
@Where(clause = "deleted = false")
@Entity
public class SpettatoreDto implements Dto {

    private String id;

    private String nome;

    private String nascita;

    private String bigliettoId;

    @Override
    public Spettatore toModel() {
        return Spettatore.builder()
                .id(UT.toLong(id))
                .nome(nome)
                .nascita(UT.toInstant(nascita))
                .biglietto(new Biglietto(bigliettoId))
                .build();
    }
}