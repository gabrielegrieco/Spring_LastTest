package it.euris.academy.aca_esame.data.model;

import it.euris.academy.aca_esame.data.archetype.Dto;
import it.euris.academy.aca_esame.data.archetype.Model;
import it.euris.academy.aca_esame.data.dto.SalaDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "sala")
@SQLDelete(sql = "UPDATE sala SET cancellato = true WHERE id=? ")
@Where(clause = "cancellato = false")
@Entity

public class Sala implements Model {

    // proprietà

    @Id
    @Column(name = "sala_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // una sala può avere molti posti a sedere;
    @Column(name = "posti")
    Long postiASedere;

    @Column(name="cancellato")
    @Builder.Default
    private Boolean cancellato = false;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch=FetchType.EAGER)
            @JoinTable(name = "proiezione_sala"
                    ,joinColumns = @JoinColumn(name = "s_id", referencedColumnName = "sala_id")
                    ,inverseJoinColumns = @JoinColumn(name = "p_id", referencedColumnName = "proiezione_id"))
    private Set<Proiezione> proiezioni = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "cinema_id", nullable = false)
    private Cinema cinema;

    // metodi calcolo e controllo

    public Boolean controlloPostiDisponibili(){
        return Boolean.TRUE;
    };

    public Boolean salaVuota(){
        return null;
    };

    public Double CalcolaIncassoSala(){
        return null;
    };

    @Override
    public SalaDto toDto() {
        return SalaDto.builder()
                .id(String.valueOf(id))
                .postiASedere(String.valueOf(postiASedere))
                .cancellato(String.valueOf(cancellato))
                .cinemaId(cinema.getId().toString())
                .build();
    }
}
