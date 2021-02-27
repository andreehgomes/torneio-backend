package br.com.pardalzada.torneioapi.core.impl.permissao;

import br.com.pardalzada.torneioapi.core.entities.PermissaoEntity;
import br.com.pardalzada.torneioapi.core.interfaces.permissao.PermissaoFindByIdUseCase;
import br.com.pardalzada.torneioapi.core.interfaces.permissao.PermissaoUpdateUseCase;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.PermissaoDBPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PermissaoUpdateUseCaseImpl implements PermissaoUpdateUseCase {

    private final PermissaoFindByIdUseCase permissaoFindByIdUseCase;
    private final PermissaoDBPort permissaoDBPort;

    @Override
    public PermissaoEntity update(Long id, PermissaoEntity permissaoEntity) {
        PermissaoEntity permissaoEntityResult = permissaoDBPort.findById(id);

        BeanUtils.copyProperties(permissaoEntity, permissaoEntityResult, "codigo");
        return permissaoDBPort.createAndUpdate(permissaoEntityResult);
    }
}
