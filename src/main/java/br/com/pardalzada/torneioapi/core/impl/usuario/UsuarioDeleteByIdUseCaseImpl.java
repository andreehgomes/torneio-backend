package br.com.pardalzada.torneioapi.core.impl.usuario;

import br.com.pardalzada.torneioapi.core.interfaces.usuario.UsuarioDeleteByIdUseCase;
import br.com.pardalzada.torneioapi.core.interfaces.usuario.UsuarioFindByIdUseCase;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.UsuarioDBPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsuarioDeleteByIdUseCaseImpl implements UsuarioDeleteByIdUseCase {

    private final UsuarioFindByIdUseCase usuarioFindByIdUseCase;
    private final UsuarioDBPort usuarioDBPort;

    @Override
    public void deleteById(Long id) {
        usuarioFindByIdUseCase.findById(id);
        usuarioDBPort.deleteById(id);
    }
}
