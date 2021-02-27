package br.com.pardalzada.torneioapi.core.impl.usuario;

import br.com.pardalzada.torneioapi.core.entities.UsuarioEntity;
import br.com.pardalzada.torneioapi.core.interfaces.usuario.UsuarioFindByIdUseCase;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.UsuarioDBPort;
import br.com.pardalzada.torneioapi.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsuarioFindByIdUseCaseImpl implements UsuarioFindByIdUseCase {

    private final UsuarioDBPort usuarioDBPort;

    @Override
    public UsuarioEntity findById(Long id) {
        UsuarioEntity usuarioEntity = usuarioDBPort.findById(id);

        if (usuarioEntity != null) {
            return usuarioEntity;
        } else {
            throw new ResourceNotFoundException(id);
        }
    }
}
