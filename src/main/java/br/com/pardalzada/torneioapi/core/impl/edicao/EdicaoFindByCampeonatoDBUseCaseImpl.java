package br.com.pardalzada.torneioapi.core.impl.edicao;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.pardalzada.torneioapi.core.entities.EdicaoEntity;
import br.com.pardalzada.torneioapi.core.interfaces.edicao.EdicaoFindByCampeonatoDBUseCase;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.EdicaoDBPort;
import br.com.pardalzada.torneioapi.dataproviders.models.CampeonatoDB;
import br.com.pardalzada.torneioapi.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EdicaoFindByCampeonatoDBUseCaseImpl implements EdicaoFindByCampeonatoDBUseCase {
	
	private final EdicaoDBPort edicaoDBPort;
	
	@Override
	public List<EdicaoEntity> findByCampeonatoDB(CampeonatoDB campeonatoDB) {
		List<EdicaoEntity> edicaoEntity = edicaoDBPort.findByCampeonatoDB(campeonatoDB);
		
		if (edicaoEntity != null) {
			return edicaoEntity;
		} else {
			throw new ResourceNotFoundException(campeonatoDB);
		}
	}
	

}
