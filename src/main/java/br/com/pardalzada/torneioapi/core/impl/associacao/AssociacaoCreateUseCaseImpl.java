package br.com.pardalzada.torneioapi.core.impl.associacao;

import br.com.pardalzada.torneioapi.core.entities.AssociacaoEntity;
import br.com.pardalzada.torneioapi.core.interfaces.associacao.AssociacaoCreateUseCase;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.AssociacaoDBPort;
import br.com.pardalzada.torneioapi.exceptions.ResourceDuplicatedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AssociacaoCreateUseCaseImpl implements AssociacaoCreateUseCase {

    private final AssociacaoDBPort associacaoDBPort;

    @Override
    public AssociacaoEntity create(AssociacaoEntity associacaoEntity) {
        AssociacaoEntity associacaoEntityResult = associacaoDBPort.findByCnpj(associacaoEntity.getCnpj());

        if (associacaoEntityResult == null) {
            associacaoEntityResult = associacaoDBPort.createAndUpdate(associacaoEntity);
        } else {
            throw new ResourceDuplicatedException(associacaoEntityResult.getCodigo());
        }

        return associacaoEntityResult;
    }
}
