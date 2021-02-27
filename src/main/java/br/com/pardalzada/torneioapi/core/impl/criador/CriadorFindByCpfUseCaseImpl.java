package br.com.pardalzada.torneioapi.core.impl.criador;

import org.springframework.stereotype.Component;

import br.com.pardalzada.torneioapi.core.entities.CriadorEntity;
import br.com.pardalzada.torneioapi.core.interfaces.criador.CriadorFindByCpfUseCase;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.CriadorDBPort;
import br.com.pardalzada.torneioapi.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CriadorFindByCpfUseCaseImpl implements CriadorFindByCpfUseCase {
	
	private final CriadorDBPort criadorDBPort;

    @Override
    public CriadorEntity findByCpf(String cpf) {
        CriadorEntity criadorEntity = criadorDBPort.findByCpf(cpf);

        if (criadorEntity != null) {
            return criadorEntity;
        } else {
            throw new ResourceNotFoundException(cpf);
        }
    }

}
