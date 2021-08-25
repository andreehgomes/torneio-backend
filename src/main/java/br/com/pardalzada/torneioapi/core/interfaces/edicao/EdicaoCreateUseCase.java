package br.com.pardalzada.torneioapi.core.interfaces.edicao;

import br.com.pardalzada.torneioapi.core.entities.EdicaoEntity;

public interface EdicaoCreateUseCase {
	
	EdicaoEntity create(EdicaoEntity edicaoEntity);
}
