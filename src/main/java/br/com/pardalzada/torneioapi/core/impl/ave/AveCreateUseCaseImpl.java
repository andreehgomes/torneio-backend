package br.com.pardalzada.torneioapi.core.impl.ave;

import br.com.pardalzada.torneioapi.core.entities.AveEntity;
import br.com.pardalzada.torneioapi.core.interfaces.ave.AveCreateUseCase;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.AveDBPort;
import br.com.pardalzada.torneioapi.exceptions.ResourceDuplicatedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AveCreateUseCaseImpl implements AveCreateUseCase {

    private final AveDBPort aveDBPort;

    @Override
    public AveEntity create(AveEntity aveEntity) {
        AveEntity aveEntityResult = aveDBPort.findByNome(aveEntity.getNome());

        if (aveEntityResult == null) {
            aveEntityResult = aveDBPort.createAndUpdate(aveEntity);
        } else {
            throw new ResourceDuplicatedException(aveEntityResult.getCodigo());
        }

        return aveEntityResult;
    }
}
