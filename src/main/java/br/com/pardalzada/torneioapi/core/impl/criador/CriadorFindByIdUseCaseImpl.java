package br.com.pardalzada.torneioapi.core.impl.criador;

import br.com.pardalzada.torneioapi.core.entities.CriadorEntity;
import br.com.pardalzada.torneioapi.core.interfaces.criador.CriadorFindByIdUseCase;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.CriadorDBPort;
import br.com.pardalzada.torneioapi.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CriadorFindByIdUseCaseImpl implements CriadorFindByIdUseCase {

    private final CriadorDBPort criadorDBPort;

    @Override
    public CriadorEntity findById(Long id) {
        CriadorEntity criadorEntity = criadorDBPort.findById(id);

        if (criadorEntity != null) {
            return criadorEntity;
        } else {
            throw new ResourceNotFoundException(id);
        }
    }
}
