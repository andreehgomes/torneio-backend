package br.com.pardalzada.torneioapi.core.interfaces.edicao;

import br.com.pardalzada.torneioapi.core.entities.EdicaoEntity;

public interface EdicaoFindByIdUseCase {

	EdicaoEntity findById(Long id);
}
