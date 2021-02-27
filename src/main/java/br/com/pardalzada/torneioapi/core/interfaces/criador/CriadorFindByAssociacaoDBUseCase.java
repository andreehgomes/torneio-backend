package br.com.pardalzada.torneioapi.core.interfaces.criador;

import java.util.List;

import br.com.pardalzada.torneioapi.core.entities.CriadorEntity;
import br.com.pardalzada.torneioapi.dataproviders.models.AssociacaoDB;

public interface CriadorFindByAssociacaoDBUseCase {

	List<CriadorEntity> findByAssociacaoDB(AssociacaoDB associacaoDB);
	
}
