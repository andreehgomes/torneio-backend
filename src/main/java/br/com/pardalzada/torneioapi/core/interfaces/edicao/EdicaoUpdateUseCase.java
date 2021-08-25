package br.com.pardalzada.torneioapi.core.interfaces.edicao;

import br.com.pardalzada.torneioapi.core.entities.EdicaoEntity;

public interface EdicaoUpdateUseCase {

	EdicaoEntity update(Long id, EdicaoEntity edicaoEntity);
}
