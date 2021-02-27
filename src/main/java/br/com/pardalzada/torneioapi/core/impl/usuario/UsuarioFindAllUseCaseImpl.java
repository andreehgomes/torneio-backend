package br.com.pardalzada.torneioapi.core.impl.usuario;

import br.com.pardalzada.torneioapi.core.entities.UsuarioEntity;
import br.com.pardalzada.torneioapi.core.interfaces.usuario.UsuarioFindAllUseCase;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.UsuarioDBPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UsuarioFindAllUseCaseImpl implements UsuarioFindAllUseCase {

    private final UsuarioDBPort usuarioDBPort;

    @Override
    public List<UsuarioEntity> findAll() {
        return usuarioDBPort.findAll();
    }
}
