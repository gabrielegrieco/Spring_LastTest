package it.euris.academy.aca_esame.data.model;

import it.euris.academy.aca_esame.data.archetype.Dto;
import it.euris.academy.aca_esame.data.archetype.Model;
import it.euris.academy.aca_esame.data.dto.SpettatoreDto;
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
public class Spettatore implements Model {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "nascita")
    private Instant nascita;

    @ManyToOne
    @JoinColumn(name = "biglietto_id", nullable = false)
    private Biglietto biglietto;

    public Spettatore(String spettatoreId) {
        if(spettatoreId != null) {
            this.id = UT.toLong(spettatoreId);
        }
    }

    // metodi controllo e calcolo età;

    public Boolean maggiorenne(){
        return null;
    };

    public Long etàSpettatore() {
        return null;
    }

    @Override
    public SpettatoreDto toDto() {
        return SpettatoreDto.builder()
                .id(id.toString())

                .build();
    }
}
