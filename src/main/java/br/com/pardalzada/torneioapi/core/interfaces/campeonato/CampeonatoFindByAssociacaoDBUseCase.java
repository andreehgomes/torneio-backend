package br.com.pardalzada.torneioapi.core.interfaces.campeonato;

import java.util.List;

import br.com.pardalzada.torneioapi.core.entities.CampeonatoEntity;
import br.com.pardalzada.torneioapi.dataproviders.models.AssociacaoDB;

public interface CampeonatoFindByAssociacaoDBUseCase {
	
	List<CampeonatoEntity> findByAssociacaoDB(AssociacaoDB associacaoDB);
	
}
