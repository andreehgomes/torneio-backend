package br.com.pardalzada.torneioapi.core.impl.permissao;

import br.com.pardalzada.torneioapi.core.entities.PermissaoEntity;
import br.com.pardalzada.torneioapi.core.interfaces.permissao.PermissaoFindByIdUseCase;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.PermissaoDBPort;
import br.com.pardalzada.torneioapi.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PermissaoFindByIdUseCaseImpl implements PermissaoFindByIdUseCase {

    private final PermissaoDBPort permissaoDBPort;

    @Override
    public PermissaoEntity findById(Long id) {
        PermissaoEntity permissaoEntity = permissaoDBPort.findById(id);

        if (permissaoEntity != null) {
            return permissaoEntity;
        } else {
            throw new ResourceNotFoundException(id);
        }
    }
}
