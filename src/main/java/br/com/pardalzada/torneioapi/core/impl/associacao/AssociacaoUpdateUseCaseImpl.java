package br.com.pardalzada.torneioapi.core.impl.associacao;

import br.com.pardalzada.torneioapi.core.entities.AssociacaoEntity;
import br.com.pardalzada.torneioapi.core.interfaces.associacao.AssociacaoFindByIdUseCase;
import br.com.pardalzada.torneioapi.core.interfaces.associacao.AssociacaoUpdateUseCase;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.AssociacaoDBPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AssociacaoUpdateUseCaseImpl implements AssociacaoUpdateUseCase {

    private final AssociacaoFindByIdUseCase associacaoFindByIdUseCase;
    private final AssociacaoDBPort associacaoDBPort;

    @Override
    public AssociacaoEntity update(Long id, AssociacaoEntity associacaoEntity) {
        AssociacaoEntity associacaoEntityResult = associacaoFindByIdUseCase.findById(id);

        BeanUtils.copyProperties(associacaoEntity, associacaoEntityResult, "codigo");
        return associacaoDBPort.createAndUpdate(associacaoEntityResult);
    }
}
