package br.com.pardalzada.torneioapi.core.interfaces.permissao;

import br.com.pardalzada.torneioapi.core.entities.PermissaoEntity;

import java.util.List;

public interface PermissaoFindAllUseCase {

    List<PermissaoEntity> findAll();
}
