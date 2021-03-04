package br.com.pardalzada.torneioapi.entrypoints.mappers;

import br.com.pardalzada.torneioapi.core.entities.UsuarioEntity;
import br.com.pardalzada.torneioapi.entrypoints.entities.UsuarioHttp;
import br.com.pardalzada.torneioapi.service.FromToMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsuarioHttpMapper extends FromToMapper<UsuarioHttp, UsuarioEntity> {

    private final PermissaoHttpMapper permissaoHttpMapper;

    @Override
    protected UsuarioHttp fromNonNull(UsuarioEntity usuarioEntity) {
        return UsuarioHttp.builder()
                .codigo(usuarioEntity.getCodigo())
                .email(usuarioEntity.getEmail())
                .senha(usuarioEntity.getSenha())
                .tipo(usuarioEntity.getTipo())
                .permissoes(permissaoHttpMapper.fromList(usuarioEntity.getPermissoes()))
                .build();
    }

    @Override
    protected UsuarioEntity toNonNull(UsuarioHttp usuarioHttp) {
        return UsuarioEntity.builder()
                .codigo(usuarioHttp.getCodigo())
                .email(usuarioHttp.getEmail())
                .senha(usuarioHttp.getSenha())
                .tipo(usuarioHttp.getTipo())
                .permissoes(permissaoHttpMapper.toList(usuarioHttp.getPermissoes()))
                .build();
    }
}
