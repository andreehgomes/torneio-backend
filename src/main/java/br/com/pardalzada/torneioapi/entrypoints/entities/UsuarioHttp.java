package br.com.pardalzada.torneioapi.entrypoints.entities;

import lombok.*;

import javax.persistence.Id;
import java.util.List;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioHttp {

    @Id
    private Long codigo;
    private String email;
    private String senha;
    private String tipo;
    private List<PermissaoHttp> permissoes;
    private CriadorHttp criadorHttp;
    private AssociacaoHttp associacaoHttp;
}
