package br.com.pardalzada.torneioapi.dataproviders.interfaces;

import java.util.List;

import br.com.pardalzada.torneioapi.core.entities.CampeonatoEntity;
import br.com.pardalzada.torneioapi.dataproviders.models.AssociacaoDB;
import br.com.pardalzada.torneioapi.dataproviders.models.CampeonatoDB;

public interface CampeonatoDBPort {

	List<CampeonatoEntity> findAll();
	
	List<CampeonatoEntity> findByAssociacaoDB(AssociacaoDB associacaoDB);
	
	CampeonatoEntity createAndUpdate(CampeonatoEntity campeonatoEntity);
	
}
