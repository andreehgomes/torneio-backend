package br.com.pardalzada.torneioapi.core.interfaces.usuario;

import br.com.pardalzada.torneioapi.core.entities.UsuarioEntity;

public interface UsuarioCreateUseCase {

    UsuarioEntity create(UsuarioEntity usuarioEntity);
}
