package br.com.pardalzada.torneioapi.core.interfaces.campeonato;

import java.util.List;

import br.com.pardalzada.torneioapi.core.entities.CampeonatoEntity;

public interface CampeonatoFindAllUseCase {
	List<CampeonatoEntity> findAll();
}
