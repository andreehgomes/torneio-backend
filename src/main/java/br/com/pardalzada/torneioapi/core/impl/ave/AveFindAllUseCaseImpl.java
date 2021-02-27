package br.com.pardalzada.torneioapi.core.impl.ave;

import br.com.pardalzada.torneioapi.core.entities.AveEntity;
import br.com.pardalzada.torneioapi.core.interfaces.ave.AveFindAllUseCase;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.AveDBPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AveFindAllUseCaseImpl implements AveFindAllUseCase {

    private final AveDBPort aveDBPort;

    @Override
    public List<AveEntity> findAll() {
        return aveDBPort.findAll();
    }
}
