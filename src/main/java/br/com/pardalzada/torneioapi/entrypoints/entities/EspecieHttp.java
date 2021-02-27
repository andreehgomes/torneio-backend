package br.com.pardalzada.torneioapi.entrypoints.entities;

import lombok.*;

import javax.persistence.Id;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class EspecieHttp {

    @Id
    private Long codigo;
    private String nome;
    private String nomeCientifico;
}
