package br.com.pardalzada.torneioapi.core.impl.usuario;

import br.com.pardalzada.torneioapi.core.entities.UsuarioEntity;
import br.com.pardalzada.torneioapi.core.interfaces.usuario.UsuarioFindByIdUseCase;
import br.com.pardalzada.torneioapi.core.interfaces.usuario.UsuarioUpdateUseCase;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.UsuarioDBPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsuarioUpdateUseCaseImpl implements UsuarioUpdateUseCase {

    private final UsuarioFindByIdUseCase usuarioFindByIdUseCase;
    private final UsuarioDBPort usuarioDBPort;

    @Override
    public UsuarioEntity update(Long id, UsuarioEntity usuarioEntity) {
        UsuarioEntity usuarioEntityResult = usuarioFindByIdUseCase.findById(id);

        BeanUtils.copyProperties(usuarioEntity, usuarioEntityResult, "codigo", "senha");
        return usuarioDBPort.createAndUpdate(usuarioEntityResult);
    }
}
