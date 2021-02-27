package br.com.pardalzada.torneioapi.core.entities;

import lombok.*;

import javax.persistence.Id;
import java.util.List;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEntity {

    @Id
    private Long codigo;
    private String email;
    private String senha;
    private String tipo;
    private List<PermissaoEntity> permissoes;
    private CriadorEntity criadorEntity;
    private AssociacaoEntity associacaoEntity;
}
