package br.com.pardalzada.torneioapi.core.impl.campeonato;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.pardalzada.torneioapi.core.entities.CampeonatoEntity;
import br.com.pardalzada.torneioapi.core.interfaces.campeonato.CampeonatoFindAllUseCase;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.CampeonatoDBPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CampeonatoFindAllUseCaseImpl implements CampeonatoFindAllUseCase {
	
	private final CampeonatoDBPort campeonatoDBPort;
	
	@Override
	public List<CampeonatoEntity> findAll() {		
		return campeonatoDBPort.findAll();
	}

}
