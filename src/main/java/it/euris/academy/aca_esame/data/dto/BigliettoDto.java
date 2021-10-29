package it.euris.academy.aca_esame.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.academy.aca_esame.data.archetype.Dto;
import it.euris.academy.aca_esame.data.archetype.Model;
import it.euris.academy.aca_esame.data.model.Biglietto;
import it.euris.academy.aca_esame.utils.UT;
import lombok.*;
import java.util.List;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BigliettoDto implements Dto {

    private String id;

    private String postoAssegnato;

    private String prezzo;

    private String deleted;

    @JsonIgnore
    private List<SpettatoreDto> acquirente;


    @Override
    public Biglietto toModel() {
        return Biglietto.builder()
                .id(UT.toLong(id))
                .deleted(Boolean.valueOf(deleted))
                .prezzo(Double.valueOf(prezzo))
                .postoAssegnato(postoAssegnato)
                .build();
    }
}
