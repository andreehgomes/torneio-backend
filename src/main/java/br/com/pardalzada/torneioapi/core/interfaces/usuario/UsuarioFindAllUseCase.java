package br.com.pardalzada.torneioapi.core.interfaces.usuario;

import br.com.pardalzada.torneioapi.core.entities.UsuarioEntity;

import java.util.List;

public interface UsuarioFindAllUseCase {

    List<UsuarioEntity> findAll();
}
