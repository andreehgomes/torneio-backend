package br.com.pardalzada.torneioapi.core.impl.ave;

import br.com.pardalzada.torneioapi.core.entities.AveEntity;
import br.com.pardalzada.torneioapi.core.interfaces.ave.AveFindByIdUseCase;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.AveDBPort;
import br.com.pardalzada.torneioapi.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AveFindByIdUseCaseImpl implements AveFindByIdUseCase {

    private final AveDBPort aveDBPort;

    @Override
    public AveEntity findById(Long id) {
        AveEntity aveEntity = aveDBPort.findById(id);

        if (aveEntity != null) {        	
            return aveEntity;
        } else {
            throw new ResourceNotFoundException(id);
        }
    }
}
