package br.com.pardalzada.torneioapi.core.entities;

import lombok.*;

import javax.persistence.Id;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class AssociacaoEntity {

    @Id
    private Long codigo;
    private String cnpj;
    private String sigla;
    private String nome;
    private EnderecoEntity enderecoEntity;
    private UsuarioEntity usuarioEntity;
}
