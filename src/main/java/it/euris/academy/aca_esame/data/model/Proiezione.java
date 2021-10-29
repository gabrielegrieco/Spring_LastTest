package it.euris.academy.aca_esame.data.model;

import it.euris.academy.aca_esame.data.archetype.Dto;
import it.euris.academy.aca_esame.data.archetype.Model;
import it.euris.academy.aca_esame.data.dto.ProiezioneDto;
import it.euris.academy.aca_esame.data.enums.Genere;
import it.euris.academy.aca_esame.utils.UT;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Entity

@Table(name = "proiezione")
@SQLDelete(sql = "UPDATE proiezione p SET p.cancellato = true WHERE p.id=?")
@Where(clause = "cancellato=false")
public class Proiezione implements Model {

    @Id
    @Column(name = "proiezione_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titolo")
    private String titolo;

    @Column(name = "regista")
    private String regista;

    @Column(name = "produzione")
    private String casaProduttrice;

    @Column(name = "genere")
    private Genere genere;

    @Column(name = "durata")
    private Long durata;

    @Column(name = "età")
    private Long etàMinima;

    @Column(name="cancellato")
    @Builder.Default
    private Boolean cancellato = false;

    // relazione con proiezione
    @ManyToMany(mappedBy = "proiezioni", fetch = FetchType.LAZY)
    private Set<Sala> sale = new HashSet<>();

    public Proiezione(String proiezioneId) {
        this.id = UT.toLong(proiezioneId);
    }

    @Override
    public ProiezioneDto toDto() {
        return ProiezioneDto.builder()
                .id(String.valueOf(id))
                .titolo(titolo)
                .regista(regista)
                .genere(UT.getGenere(genere))
                .casaProduttrice(casaProduttrice)
                .durata(String.valueOf(durata))
                .etàMinima(String.valueOf(etàMinima))
                .build();
    }
}
