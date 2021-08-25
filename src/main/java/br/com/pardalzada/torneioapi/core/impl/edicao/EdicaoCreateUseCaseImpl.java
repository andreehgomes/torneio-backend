package br.com.pardalzada.torneioapi.core.impl.edicao;

import br.com.pardalzada.torneioapi.core.entities.EdicaoEntity;
import br.com.pardalzada.torneioapi.core.interfaces.edicao.EdicaoCreateUseCase;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.EdicaoDBPort;
import br.com.pardalzada.torneioapi.exceptions.ResourceDuplicatedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EdicaoCreateUseCaseImpl implements EdicaoCreateUseCase {
	
	private final EdicaoDBPort edicaoDBPort;

	@Override
	public EdicaoEntity create(EdicaoEntity edicaoEntity) {
		EdicaoEntity edicaoEntityResult = edicaoDBPort.findById(edicaoEntity.getCodigo());
		
		if (edicaoEntityResult == null) {
			edicaoEntityResult = edicaoDBPort.createAndUpdate(edicaoEntity);
		} else {
			throw new ResourceDuplicatedException(edicaoEntityResult.getCodigo());
		}
		
		return edicaoEntityResult;
	}
}
