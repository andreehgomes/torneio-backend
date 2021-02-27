package br.com.pardalzada.torneioapi.core.interfaces.usuario;

import br.com.pardalzada.torneioapi.core.entities.UsuarioEntity;

public interface UsuarioFindByIdUseCase {

    UsuarioEntity findById(Long id);
}
