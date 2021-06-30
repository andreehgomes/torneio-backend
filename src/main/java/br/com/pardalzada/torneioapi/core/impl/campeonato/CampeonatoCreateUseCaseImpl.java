package br.com.pardalzada.torneioapi.core.impl.campeonato;

import org.springframework.stereotype.Component;

import br.com.pardalzada.torneioapi.core.entities.CampeonatoEntity;
import br.com.pardalzada.torneioapi.core.interfaces.campeonato.CampeonatoCreateUseCase;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.CampeonatoDBPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CampeonatoCreateUseCaseImpl implements CampeonatoCreateUseCase {
	
	private final CampeonatoDBPort campeonatoDBPort;

	@Override
	public CampeonatoEntity create(CampeonatoEntity campeonatoEntity) {				
		return campeonatoDBPort.createAndUpdate(campeonatoEntity);
	}

}
