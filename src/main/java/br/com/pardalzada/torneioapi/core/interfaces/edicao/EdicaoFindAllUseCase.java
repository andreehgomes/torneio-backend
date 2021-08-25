package br.com.pardalzada.torneioapi.core.interfaces.edicao;

import java.util.List;

import br.com.pardalzada.torneioapi.core.entities.EdicaoEntity;

public interface EdicaoFindAllUseCase {

	List<EdicaoEntity> findAll();
}
