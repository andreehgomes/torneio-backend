package br.com.pardalzada.torneioapi.core.impl.especie;

import br.com.pardalzada.torneioapi.core.entities.EspecieEntity;
import br.com.pardalzada.torneioapi.core.interfaces.especie.EspecieCreateUseCase;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.EspecieDBPort;
import br.com.pardalzada.torneioapi.exceptions.ResourceDuplicatedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EspecieCreateUseCaseImpl implements EspecieCreateUseCase {

    private final EspecieDBPort especieDBPort;

    @Override
    public EspecieEntity create(EspecieEntity especieEntity) {
        EspecieEntity especieEntityResult = especieDBPort.findByNome(especieEntity.getNome());

        if (especieEntityResult == null) {
            especieEntityResult = especieDBPort.createAndUpdate(especieEntity);
        } else {
            throw new ResourceDuplicatedException(especieEntityResult.getCodigo());
        }

        return especieEntityResult;
    }
}
