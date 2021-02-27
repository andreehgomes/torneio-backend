package br.com.pardalzada.torneioapi.core.entities;

import lombok.*;

import javax.persistence.Id;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class EspecieEntity {

    @Id
    private Long codigo;
    private String nome;
    private String nomeCientifico;
}
