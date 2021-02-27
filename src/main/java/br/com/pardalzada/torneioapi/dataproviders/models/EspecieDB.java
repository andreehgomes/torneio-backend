package br.com.pardalzada.torneioapi.dataproviders.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_especie")
public class EspecieDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "nome_cientifico", nullable = false)
    private String nomeCientifico;

    @OneToMany(mappedBy = "especieDB")
    private List<AveDB> aves;
}
