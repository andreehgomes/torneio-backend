package br.com.pardalzada.torneioapi.core.interfaces.associacao;

import br.com.pardalzada.torneioapi.core.entities.AssociacaoEntity;

public interface AssociacaoFindByIdUseCase {

    AssociacaoEntity findById(Long id);
}
