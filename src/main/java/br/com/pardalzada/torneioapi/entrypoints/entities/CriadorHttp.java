package br.com.pardalzada.torneioapi.entrypoints.entities;

import lombok.*;

import javax.persistence.Id;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class CriadorHttp {

    @Id
    private Long codigo;
    private String nome;
    private String sobrenome;
    private String telefone;
    private String cpf;
    private String rg;
    private String ctf;
    private Boolean ativo;
    private AssociacaoHttp associacaoHttp;
    private EnderecoHttp enderecoHttp;
    private UsuarioHttp usuarioHttp;
    private Boolean aceiteAssociacao;
}
