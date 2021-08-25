package br.com.pardalzada.torneioapi.core.interfaces.edicao;

import java.util.List;

import br.com.pardalzada.torneioapi.core.entities.EdicaoEntity;
import br.com.pardalzada.torneioapi.dataproviders.models.CampeonatoDB;

public interface EdicaoFindByCampeonatoDBUseCase {

	List<EdicaoEntity> findByCampeonatoDB(CampeonatoDB campeonatoDB);
	
}
