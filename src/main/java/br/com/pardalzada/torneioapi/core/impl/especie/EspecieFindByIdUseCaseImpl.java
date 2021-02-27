package br.com.pardalzada.torneioapi.core.impl.especie;

import br.com.pardalzada.torneioapi.core.entities.EspecieEntity;
import br.com.pardalzada.torneioapi.core.interfaces.especie.EspecieFindByIdUseCase;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.EspecieDBPort;
import br.com.pardalzada.torneioapi.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EspecieFindByIdUseCaseImpl implements EspecieFindByIdUseCase {

    private final EspecieDBPort especieDBPort;

    @Override
    public EspecieEntity findById(Long id) {
        EspecieEntity especieEntity = especieDBPort.findById(id);

        if (especieEntity != null) {
            return especieEntity;
        } else {
            throw new ResourceNotFoundException(id);
        }
    }
}
