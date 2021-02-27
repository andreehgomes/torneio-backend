package br.com.pardalzada.torneioapi.core.entities;

import lombok.*;

import javax.persistence.Id;
import java.util.List;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class PermissaoEntity {

    @Id
    private Long codigo;
    private String nome;
    private List<UsuarioEntity> usuarios;
}
