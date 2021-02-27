package br.com.pardalzada.torneioapi.core.interfaces.permissao;

import br.com.pardalzada.torneioapi.core.entities.PermissaoEntity;

public interface PermissaoUpdateUseCase {

    PermissaoEntity update(Long id, PermissaoEntity permissaoEntity);
}
