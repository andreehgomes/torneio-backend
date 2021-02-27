package br.com.pardalzada.torneioapi.core.impl.permissao;

import br.com.pardalzada.torneioapi.core.interfaces.permissao.PermissaoDeleteByIdUseCase;
import br.com.pardalzada.torneioapi.core.interfaces.permissao.PermissaoFindByIdUseCase;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.PermissaoDBPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PermissaoDeleteByIdUseCaseImpl implements PermissaoDeleteByIdUseCase {

    private final PermissaoFindByIdUseCase permissaoFindByIdUseCase;
    private final PermissaoDBPort permissaoDBPort;

    @Override
    public void deleteById(Long id) {
        permissaoFindByIdUseCase.findById(id);
        permissaoDBPort.deleteById(id);
    }
}
