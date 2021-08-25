package br.com.pardalzada.torneioapi.core.impl.edicao;

import org.springframework.stereotype.Component;

import br.com.pardalzada.torneioapi.core.interfaces.edicao.EdicaoDeleteByIdUseCase;
import br.com.pardalzada.torneioapi.core.interfaces.edicao.EdicaoFindByIdUseCase;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.EdicaoDBPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EdicaoDeleteByIdUseCaseImpl implements EdicaoDeleteByIdUseCase {

	private final EdicaoFindByIdUseCase edicaoFindByIdUseCase;
	private final EdicaoDBPort edicaoDBPort;
	
	@Override
	public void deleteById(Long id) {
		edicaoFindByIdUseCase.findById(id);
		edicaoDBPort.deleteById(id);
	}
	
}
