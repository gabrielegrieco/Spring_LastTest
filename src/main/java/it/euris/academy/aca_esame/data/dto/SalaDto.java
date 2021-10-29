package it.euris.academy.aca_esame.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.academy.aca_esame.data.archetype.Dto;
import it.euris.academy.aca_esame.data.archetype.Model;
import it.euris.academy.aca_esame.data.model.Cinema;
import it.euris.academy.aca_esame.data.model.Sala;
import it.euris.academy.aca_esame.utils.UT;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class SalaDto implements Dto {

    private String id;

    private String postiASedere;

    private String cinemaId;

    private String cancellato;

    @JsonIgnore
    private List<ProiezioneDto> proiezioni;


    @Override
    public Sala toModel() {
        return Sala.builder()
                .id(UT.toLong(id))
                .postiASedere(UT.toLong(postiASedere))
                .cancellato(Boolean.valueOf(cancellato))
                .cinema(new Cinema(cinemaId))
                .build();
    }
}
