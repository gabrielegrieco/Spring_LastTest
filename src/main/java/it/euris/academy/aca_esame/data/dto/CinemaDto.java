package it.euris.academy.aca_esame.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.academy.aca_esame.data.archetype.Dto;
import it.euris.academy.aca_esame.data.archetype.Model;
import it.euris.academy.aca_esame.data.model.Cinema;
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
public class CinemaDto implements Dto {

    private String id;

    private String cancellato;

    @JsonIgnore
    List<SalaDto> saleCinematografiche;


    @Override
    public Cinema toModel() {
        return Cinema.builder()
                .id(UT.toLong(id))
                .cancellato(Boolean.valueOf(cancellato))
                .build();
    }
}
