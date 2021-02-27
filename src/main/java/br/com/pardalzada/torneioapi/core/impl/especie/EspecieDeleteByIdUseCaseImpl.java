package br.com.pardalzada.torneioapi.core.impl.especie;

import br.com.pardalzada.torneioapi.core.interfaces.especie.EspecieDeleteByIdUseCase;
import br.com.pardalzada.torneioapi.core.interfaces.especie.EspecieFindByIdUseCase;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.EspecieDBPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EspecieDeleteByIdUseCaseImpl implements EspecieDeleteByIdUseCase {

    private final EspecieFindByIdUseCase especieFindByIdUseCase;
    private final EspecieDBPort especieDBPort;

    @Override
    public void deleteById(Long id) {
        especieFindByIdUseCase.findById(id);
        especieDBPort.deleteById(id);
    }
}
