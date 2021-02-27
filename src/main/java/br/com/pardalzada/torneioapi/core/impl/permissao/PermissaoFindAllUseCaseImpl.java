package br.com.pardalzada.torneioapi.core.impl.permissao;

import br.com.pardalzada.torneioapi.core.entities.PermissaoEntity;
import br.com.pardalzada.torneioapi.core.interfaces.permissao.PermissaoFindAllUseCase;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.PermissaoDBPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PermissaoFindAllUseCaseImpl implements PermissaoFindAllUseCase {

    private final PermissaoDBPort permissaoDBPort;

    @Override
    public List<PermissaoEntity> findAll() {
        return permissaoDBPort.findAll();
    }
}
