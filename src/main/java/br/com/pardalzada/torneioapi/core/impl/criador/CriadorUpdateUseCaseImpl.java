package br.com.pardalzada.torneioapi.core.impl.criador;

import br.com.pardalzada.torneioapi.core.entities.CriadorEntity;
import br.com.pardalzada.torneioapi.core.interfaces.criador.CriadorFindByIdUseCase;
import br.com.pardalzada.torneioapi.core.interfaces.criador.CriadorUpdateUseCase;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.CriadorDBPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CriadorUpdateUseCaseImpl implements CriadorUpdateUseCase {

    private final CriadorFindByIdUseCase criadorFindByIdUseCase;
    private final CriadorDBPort criadorDBPort;

    @Override
    public CriadorEntity update(Long id, CriadorEntity criadorEntity) {
        CriadorEntity criadorEntityResult = criadorFindByIdUseCase.findById(id);

        BeanUtils.copyProperties(criadorEntity, criadorEntityResult, "codigo");
        return criadorDBPort.createAndUpdate(criadorEntityResult);
    }
}
