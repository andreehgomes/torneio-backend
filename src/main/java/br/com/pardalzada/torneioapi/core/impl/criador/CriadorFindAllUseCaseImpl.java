package br.com.pardalzada.torneioapi.core.impl.criador;

import br.com.pardalzada.torneioapi.core.entities.CriadorEntity;
import br.com.pardalzada.torneioapi.core.interfaces.criador.CriadorFindAllUseCase;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.CriadorDBPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CriadorFindAllUseCaseImpl implements CriadorFindAllUseCase {

    private final CriadorDBPort criadorDBPort;

    @Override
    public List<CriadorEntity> findAll() {
        return criadorDBPort.findAll();
    }
}
