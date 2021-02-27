package br.com.pardalzada.torneioapi.core.interfaces.associacao;

import br.com.pardalzada.torneioapi.core.entities.AssociacaoEntity;

import java.util.List;

public interface AssociacaoFindAllUseCase {

    List<AssociacaoEntity> findAll();
}
