package br.com.pardalzada.torneioapi.core.impl.edicao;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.pardalzada.torneioapi.core.entities.EdicaoEntity;
import br.com.pardalzada.torneioapi.core.interfaces.edicao.EdicaoFindAllUseCase;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.EdicaoDBPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EdicaoFindAllUseCaseImpl implements EdicaoFindAllUseCase {

	private final EdicaoDBPort edicaoDBPort;
	
	@Override
	public List<EdicaoEntity> findAll(){
		return edicaoDBPort.findAll();
	}
	
}
