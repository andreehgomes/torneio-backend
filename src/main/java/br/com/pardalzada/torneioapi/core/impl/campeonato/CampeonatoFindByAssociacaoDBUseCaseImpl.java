package br.com.pardalzada.torneioapi.core.impl.campeonato;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.pardalzada.torneioapi.core.entities.CampeonatoEntity;
import br.com.pardalzada.torneioapi.core.interfaces.campeonato.CampeonatoFindByAssociacaoDBUseCase;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.CampeonatoDBPort;
import br.com.pardalzada.torneioapi.dataproviders.models.AssociacaoDB;
import br.com.pardalzada.torneioapi.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CampeonatoFindByAssociacaoDBUseCaseImpl implements CampeonatoFindByAssociacaoDBUseCase{
	
	private final CampeonatoDBPort campeonatoDBPort;

	@Override
	public List<CampeonatoEntity> findByAssociacaoDB(AssociacaoDB associacaoDB) {
		List<CampeonatoEntity> campeonatoEntity = campeonatoDBPort.findByAssociacaoDB(associacaoDB);
		
		if(campeonatoEntity != null) {
			return campeonatoEntity;
		}else {
			throw new ResourceNotFoundException(associacaoDB);
		}
	}

}
