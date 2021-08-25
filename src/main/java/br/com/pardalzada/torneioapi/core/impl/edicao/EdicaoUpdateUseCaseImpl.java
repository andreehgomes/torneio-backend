package br.com.pardalzada.torneioapi.core.impl.edicao;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import br.com.pardalzada.torneioapi.core.entities.EdicaoEntity;
import br.com.pardalzada.torneioapi.core.interfaces.edicao.EdicaoFindByIdUseCase;
import br.com.pardalzada.torneioapi.core.interfaces.edicao.EdicaoUpdateUseCase;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.EdicaoDBPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EdicaoUpdateUseCaseImpl implements EdicaoUpdateUseCase {

	private final EdicaoFindByIdUseCase edicaoFindByIdUseCase;
	private final EdicaoDBPort edicaoDBPort;
	
	@Override
	public EdicaoEntity update(Long id, EdicaoEntity edicaoEntity) {
		EdicaoEntity edicaoEntityResult = edicaoFindByIdUseCase.findById(id);
		
		BeanUtils.copyProperties(edicaoEntity, edicaoEntityResult, "codigo");
		return edicaoDBPort.createAndUpdate(edicaoEntityResult);
	}
	
}
