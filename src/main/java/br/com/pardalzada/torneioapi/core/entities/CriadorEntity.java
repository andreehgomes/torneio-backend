package br.com.pardalzada.torneioapi.core.entities;

import lombok.*;

import javax.persistence.Id;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class CriadorEntity {

    @Id
    private Long codigo;
    private String nome;
    private String sobrenome;
    private String telefone;
    private String cpf;
    private String rg;
    private String ctf;
    private Boolean ativo;
    private AssociacaoEntity associacaoEntity;
    private EnderecoEntity enderecoEntity;
    private UsuarioEntity usuarioEntity;
    private Boolean aceiteAssociacao;
}
