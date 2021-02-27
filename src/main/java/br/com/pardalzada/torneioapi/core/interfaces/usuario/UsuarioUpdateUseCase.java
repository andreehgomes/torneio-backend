package br.com.pardalzada.torneioapi.core.interfaces.usuario;

import br.com.pardalzada.torneioapi.core.entities.UsuarioEntity;

public interface UsuarioUpdateUseCase {

    UsuarioEntity update(Long id, UsuarioEntity usuarioEntity);
}
