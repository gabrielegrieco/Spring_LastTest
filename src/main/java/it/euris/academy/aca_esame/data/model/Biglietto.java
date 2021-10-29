package it.euris.academy.aca_esame.data.model;

import it.euris.academy.aca_esame.data.archetype.Dto;
import it.euris.academy.aca_esame.data.archetype.Model;
import it.euris.academy.aca_esame.data.dto.BigliettoDto;
import it.euris.academy.aca_esame.data.dto.SpettatoreDto;
import it.euris.academy.aca_esame.utils.UT;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Entity

@Table(name = "biglietto")
@SQLDelete(sql = "UPDATE biglietto b SET b.cancellato = true WHERE b.id=?")
@Where(clause = "cancellato=false")
public class Biglietto implements Model {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="postoAssegnato")
    private String postoAssegnato;

    @Column(name = "prezzo")
    private Double prezzo;

    @Column(name="cancellato")
    @Builder.Default
    private Boolean cancellato = false;

    @OneToMany(mappedBy = "biglietto", fetch = FetchType.EAGER)
    private List<Spettatore> acquirenti;


    public Biglietto(String bigliettoId) {
        if(bigliettoId != null) {
            this.id = UT.toLong(bigliettoId);
        }
    }
    
    // metodo per calcolo dello biglietto

    public Double Sconto(){
        // interfaccia per stabilire se lo spettatore è anziano ed eventualmente come calcolare lo biglietto;
        return null;
    };

    @Override
    public BigliettoDto toDto() {

        List<SpettatoreDto> acquirentiDto = new ArrayList<>();
        if(acquirenti != null){
            acquirentiDto = acquirenti.stream().map(Spettatore::toDto).collect(Collectors.toList());
        }

        return BigliettoDto.builder()
                .id(id.toString())
                .cancellato(cancellato.toString())
                .postoAssegnato(postoAssegnato)
                .prezzo(prezzo.toString())
                .acquirenti(acquirentiDto)
                .build();
    }
}
