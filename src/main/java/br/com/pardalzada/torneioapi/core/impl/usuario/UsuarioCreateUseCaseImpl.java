package br.com.pardalzada.torneioapi.core.impl.usuario;

import br.com.pardalzada.torneioapi.core.entities.UsuarioEntity;
import br.com.pardalzada.torneioapi.core.interfaces.usuario.UsuarioCreateUseCase;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.UsuarioDBPort;
import br.com.pardalzada.torneioapi.exceptions.ResourceDuplicatedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsuarioCreateUseCaseImpl implements UsuarioCreateUseCase {

    private final UsuarioDBPort usuarioDBPort;

    @Override
    public UsuarioEntity create(UsuarioEntity usuarioEntity) {
        UsuarioEntity usuarioEntityResult = usuarioDBPort.findByEmail(usuarioEntity.getEmail());

        if (usuarioEntityResult == null) {
            usuarioEntityResult = usuarioDBPort.createAndUpdate(usuarioEntity);
        } else {
            throw new ResourceDuplicatedException(usuarioEntityResult.getCodigo());
        }

        return usuarioEntityResult;
    }
}
