package br.com.pardalzada.torneioapi.core.impl.associacao;

import br.com.pardalzada.torneioapi.core.entities.AssociacaoEntity;
import br.com.pardalzada.torneioapi.core.interfaces.associacao.AssociacaoFindByIdUseCase;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.AssociacaoDBPort;
import br.com.pardalzada.torneioapi.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AssociacaoFindByIdUseCaseImpl implements AssociacaoFindByIdUseCase {

    private final AssociacaoDBPort associacaoDBPort;

    @Override
    public AssociacaoEntity findById(Long id) {
        AssociacaoEntity associacaoEntity = associacaoDBPort.findById(id);

        if (associacaoEntity != null) {
            return associacaoEntity;
        } else {
            throw new ResourceNotFoundException(id);
        }
    }
}
