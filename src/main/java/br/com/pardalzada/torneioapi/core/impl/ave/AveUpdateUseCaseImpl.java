package br.com.pardalzada.torneioapi.core.impl.ave;

import br.com.pardalzada.torneioapi.core.entities.AveEntity;
import br.com.pardalzada.torneioapi.core.interfaces.ave.AveFindByIdUseCase;
import br.com.pardalzada.torneioapi.core.interfaces.ave.AveUpdateUseCase;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.AveDBPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AveUpdateUseCaseImpl implements AveUpdateUseCase {

    private final AveFindByIdUseCase aveFindByIdUseCase;
    private final AveDBPort aveDBPort;

    @Override
    public AveEntity update(Long id, AveEntity aveEntity) {
        AveEntity aveEntityResult = aveFindByIdUseCase.findById(id);

        BeanUtils.copyProperties(aveEntity, aveEntityResult, "codigo");
        return aveDBPort.createAndUpdate(aveEntityResult);
    }
}
