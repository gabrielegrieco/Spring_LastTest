package it.euris.academy.aca_esame.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "sala")
@SQLDelete(sql = "UPDATE sala SET deleted = true WHERE id=? ")
@Where(clause = "deleted = false")
@Entity

public class Sala {

    // proprietà

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // una sala può avere molti posti a sedere;
    @Column(name = "posti")
    Long postiASedere;

    @OneToMany(mappedBy="sala", fetch=FetchType.EAGER)
    List<Proiezione> proiezioni;

    //@ManyToOne
    //@JoinColumn(name = "cinema_id", nullable = false)
    Cinema cinema;

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
}
