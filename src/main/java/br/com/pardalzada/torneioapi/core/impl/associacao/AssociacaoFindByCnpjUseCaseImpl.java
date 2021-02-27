package br.com.pardalzada.torneioapi.core.impl.associacao;

import org.springframework.stereotype.Component;

import br.com.pardalzada.torneioapi.core.entities.AssociacaoEntity;
import br.com.pardalzada.torneioapi.core.interfaces.associacao.AssociacaoFindByCnpjUseCase;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.AssociacaoDBPort;
import br.com.pardalzada.torneioapi.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AssociacaoFindByCnpjUseCaseImpl implements AssociacaoFindByCnpjUseCase {
	
	private final AssociacaoDBPort associacaoDBPort;

    @Override
    public AssociacaoEntity findByCnpj(String cnpj) {
        AssociacaoEntity associacaoEntity = associacaoDBPort.findByCnpj(cnpj);

        if (associacaoEntity != null) {
            return associacaoEntity;
        } else {
            throw new ResourceNotFoundException(cnpj);
        }
    }

}
