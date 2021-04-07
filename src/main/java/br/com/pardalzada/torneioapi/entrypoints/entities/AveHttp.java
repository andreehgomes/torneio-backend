package br.com.pardalzada.torneioapi.entrypoints.entities;

import lombok.*;

import javax.persistence.Id;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class AveHttp {

    @Id
    private Long codigo;
    private String nome;
    private String medidaAnilha;
    private String numeroAnilha;
    private Boolean ativo;
    private EspecieHttp especieHttp;
    private CriadorHttp criadorHttp;
    private CriadorHttp criadorHttpAntigo;
    private CriadorHttp criadorHttpNovo;
}
