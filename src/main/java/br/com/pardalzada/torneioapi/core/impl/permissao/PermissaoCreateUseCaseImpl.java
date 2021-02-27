package br.com.pardalzada.torneioapi.core.impl.permissao;

import br.com.pardalzada.torneioapi.core.entities.PermissaoEntity;
import br.com.pardalzada.torneioapi.core.interfaces.permissao.PermissaoCreateUseCase;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.PermissaoDBPort;
import br.com.pardalzada.torneioapi.exceptions.ResourceDuplicatedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PermissaoCreateUseCaseImpl implements PermissaoCreateUseCase {

    private final PermissaoDBPort permissaoDBPort;

    @Override
    public PermissaoEntity create(PermissaoEntity permissaoEntity) {
        PermissaoEntity permissaoEntityResult = permissaoDBPort.findByNome(permissaoEntity.getNome());

        if (permissaoEntityResult == null) {
            permissaoEntityResult =  permissaoDBPort.createAndUpdate(permissaoEntity);
        } else {
            throw new ResourceDuplicatedException(permissaoEntityResult.getCodigo());
        }

        return permissaoEntityResult;
    }
}
