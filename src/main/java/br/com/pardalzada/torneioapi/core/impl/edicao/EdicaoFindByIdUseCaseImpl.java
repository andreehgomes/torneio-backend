package br.com.pardalzada.torneioapi.core.impl.edicao;

import org.springframework.stereotype.Component;

import br.com.pardalzada.torneioapi.core.entities.EdicaoEntity;
import br.com.pardalzada.torneioapi.core.interfaces.edicao.EdicaoFindByIdUseCase;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.EdicaoDBPort;
import br.com.pardalzada.torneioapi.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EdicaoFindByIdUseCaseImpl implements EdicaoFindByIdUseCase {

	private final EdicaoDBPort edicaoDBPort;
	
	@Override
	public EdicaoEntity findById(Long id) {
		EdicaoEntity edicaoEntity = edicaoDBPort.findById(id);
		
		if(edicaoEntity != null) {
			return edicaoEntity;
		} else {
			throw new ResourceNotFoundException(id);
		}
	}
}
