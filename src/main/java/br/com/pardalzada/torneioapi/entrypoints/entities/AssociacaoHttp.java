package br.com.pardalzada.torneioapi.entrypoints.entities;

import lombok.*;

import javax.persistence.Id;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class AssociacaoHttp {

    @Id
    private Long codigo;
    private String cnpj;
    private String sigla;
    private String nome;
    private EnderecoHttp enderecoHttp;
    private UsuarioHttp usuarioHttp;
}
