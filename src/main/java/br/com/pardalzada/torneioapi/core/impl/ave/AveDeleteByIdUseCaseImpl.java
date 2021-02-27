package br.com.pardalzada.torneioapi.core.impl.ave;

import br.com.pardalzada.torneioapi.core.interfaces.ave.AveDeleteByIdUseCase;
import br.com.pardalzada.torneioapi.core.interfaces.ave.AveFindByIdUseCase;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.AveDBPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AveDeleteByIdUseCaseImpl implements AveDeleteByIdUseCase {

    private final AveFindByIdUseCase aveFindByIdUseCase;
    private final AveDBPort aveDBPort;

    @Override
    public void deleteById(Long id) {
        aveFindByIdUseCase.findById(id);
        aveDBPort.deleteById(id);
    }
}
