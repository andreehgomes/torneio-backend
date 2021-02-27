package br.com.pardalzada.torneioapi.entrypoints.entities;

import lombok.*;

import javax.persistence.Id;
import java.util.List;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class PermissaoHttp {

    @Id
    private Long codigo;
    private String nome;
    private List<UsuarioHttp> usuarios;
}
