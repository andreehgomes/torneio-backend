package br.com.pardalzada.torneioapi.core.impl.criador;

import br.com.pardalzada.torneioapi.core.interfaces.criador.CriadorDeleteByIdUseCase;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.CriadorDBPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CriadorDeleteByIdUseCaseImpl implements CriadorDeleteByIdUseCase {

    private final CriadorFindByIdUseCaseImpl criadorFindByIdUseCase;
    private final CriadorDBPort criadorDBPort;

    @Override
    public void deleteById(Long id) {
        criadorFindByIdUseCase.findById(id);
        criadorDBPort.deleteById(id);
    }
}
