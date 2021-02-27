package br.com.pardalzada.torneioapi.core.impl.associacao;

import br.com.pardalzada.torneioapi.core.entities.AssociacaoEntity;
import br.com.pardalzada.torneioapi.core.interfaces.associacao.AssociacaoFindAllUseCase;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.AssociacaoDBPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AssociacaoFindAllUseCaseImpl implements AssociacaoFindAllUseCase {

    private final AssociacaoDBPort associacaoDBPort;

    @Override
    public List<AssociacaoEntity> findAll() {
        return associacaoDBPort.findAll();
    }
}
