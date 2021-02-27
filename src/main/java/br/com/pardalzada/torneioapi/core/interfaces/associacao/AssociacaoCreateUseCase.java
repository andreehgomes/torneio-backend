package br.com.pardalzada.torneioapi.core.interfaces.associacao;

import br.com.pardalzada.torneioapi.core.entities.AssociacaoEntity;

public interface AssociacaoCreateUseCase {

    AssociacaoEntity create(AssociacaoEntity associacaoEntity);
}
