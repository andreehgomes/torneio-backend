package br.com.pardalzada.torneioapi.core.impl.associacao;

import br.com.pardalzada.torneioapi.core.interfaces.associacao.AssociacaoDeleteByIdUseCase;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.AssociacaoDBPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AssociacaoDeleteByIdUseCaseImpl implements AssociacaoDeleteByIdUseCase {

    private final AssociacaoFindByIdUseCaseImpl associacaoFindByIdUseCase;
    private final AssociacaoDBPort associacaoDBPort;

    @Override
    public void deleteById(Long id) {
        associacaoFindByIdUseCase.findById(id);
        associacaoDBPort.deleteById(id);
    }
}
