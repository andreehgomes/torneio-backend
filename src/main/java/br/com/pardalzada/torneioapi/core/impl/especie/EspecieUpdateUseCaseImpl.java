package br.com.pardalzada.torneioapi.core.impl.especie;

import br.com.pardalzada.torneioapi.core.entities.EspecieEntity;
import br.com.pardalzada.torneioapi.core.interfaces.especie.EspecieFindByIdUseCase;
import br.com.pardalzada.torneioapi.core.interfaces.especie.EspecieUpdateUseCase;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.EspecieDBPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EspecieUpdateUseCaseImpl implements EspecieUpdateUseCase {

    private final EspecieFindByIdUseCase especieFindByIdUseCase;
    private final EspecieDBPort especieDBPort;

    @Override
    public EspecieEntity update(Long id, EspecieEntity especieEntity) {
        EspecieEntity especieEntityResult = especieFindByIdUseCase.findById(id);

        BeanUtils.copyProperties(especieEntity, especieEntityResult, "codigo");
        return especieDBPort.createAndUpdate(especieEntityResult);
    }
}
