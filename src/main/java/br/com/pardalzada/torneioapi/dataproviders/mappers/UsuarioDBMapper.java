package br.com.pardalzada.torneioapi.dataproviders.mappers;

import br.com.pardalzada.torneioapi.core.entities.UsuarioEntity;
import br.com.pardalzada.torneioapi.dataproviders.models.UsuarioDB;
import br.com.pardalzada.torneioapi.service.FromToMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsuarioDBMapper extends FromToMapper<UsuarioDB, UsuarioEntity> {

    private final PermissaoDBMapper permissaoDBMapper;

    @Override
    protected UsuarioDB fromNonNull(UsuarioEntity usuarioEntity) {
        return UsuarioDB.builder()
                .codigo(usuarioEntity.getCodigo())
                .email(usuarioEntity.getEmail())
                .senha(usuarioEntity.getSenha())
                .tipo(usuarioEntity.getTipo())
                .permissoes(permissaoDBMapper.fromList(usuarioEntity.getPermissoes()))
                .build();
    }

    @Override
    protected UsuarioEntity toNonNull(UsuarioDB usuarioDB) {
        return UsuarioEntity.builder()
                .codigo(usuarioDB.getCodigo())
                .email(usuarioDB.getEmail())
                .senha(usuarioDB.getSenha())
                .tipo(usuarioDB.getTipo())
                .permissoes(permissaoDBMapper.toList(usuarioDB.getPermissoes()))
                .build();
    }
}
