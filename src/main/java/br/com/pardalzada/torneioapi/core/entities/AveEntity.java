package br.com.pardalzada.torneioapi.core.entities;

import lombok.*;

import javax.persistence.Id;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class AveEntity {

    @Id
    private Long codigo;
    private String nome;
    private String medidaAnilha;
    private String numeroAnilha;
    private Boolean ativo;
    private EspecieEntity especieEntity;
    private CriadorEntity criadorEntity;
}
