package br.com.pardalzada.torneioapi.core.impl.especie;

import br.com.pardalzada.torneioapi.core.entities.EspecieEntity;
import br.com.pardalzada.torneioapi.core.interfaces.especie.EspecieFindAllUseCase;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.EspecieDBPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EspecieFindAllUseCaseImpl implements EspecieFindAllUseCase {

    private final EspecieDBPort especieDBPort;

    @Override
    public List<EspecieEntity> findAll() {
        return especieDBPort.findAll();
    }
}
