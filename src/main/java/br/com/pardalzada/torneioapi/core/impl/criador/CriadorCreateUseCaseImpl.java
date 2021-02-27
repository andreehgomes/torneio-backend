package br.com.pardalzada.torneioapi.core.impl.criador;

import br.com.pardalzada.torneioapi.core.entities.CriadorEntity;
import br.com.pardalzada.torneioapi.core.interfaces.criador.CriadorCreateUseCase;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.CriadorDBPort;
import br.com.pardalzada.torneioapi.exceptions.ResourceDuplicatedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CriadorCreateUseCaseImpl implements CriadorCreateUseCase {

    private final CriadorDBPort criadorDBPort;

    @Override
    public CriadorEntity create(CriadorEntity criadorEntity) {
        CriadorEntity criadorEntityResult = criadorDBPort.findByCpf(criadorEntity.getCpf());

        if (criadorEntityResult == null) {
            criadorEntityResult = criadorDBPort.createAndUpdate(criadorEntity);
        } else {
            throw new ResourceDuplicatedException(criadorEntityResult.getCodigo());
        }

        return criadorEntityResult;
    }
}
