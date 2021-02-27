package br.com.pardalzada.torneioapi.dataproviders.impl;

import br.com.pardalzada.torneioapi.core.entities.UsuarioEntity;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.UsuarioDBPort;
import br.com.pardalzada.torneioapi.dataproviders.mappers.UsuarioDBMapper;
import br.com.pardalzada.torneioapi.dataproviders.models.UsuarioDB;
import br.com.pardalzada.torneioapi.dataproviders.repositories.UsuarioDBRepository;
import br.com.pardalzada.torneioapi.exceptions.ListResourceEmptyException;
import br.com.pardalzada.torneioapi.exceptions.RepositoryException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UsuarioDBPortImpl implements UsuarioDBPort {

    private final UsuarioDBMapper usuarioDBMapper;
    private final UsuarioDBRepository usuarioDBRepository;

    @Override
    public List<UsuarioEntity> findAll() {
        List<UsuarioDB> usuarioDBList = usuarioDBRepository.findAll();

        if (!usuarioDBList.isEmpty()) {
            return usuarioDBMapper.toList(usuarioDBList);
        } else {
            throw new ListResourceEmptyException();
        }
    }

    @Override
    public UsuarioEntity findById(Long id) {
        Optional<UsuarioDB> usuarioDB = usuarioDBRepository.findById(id);
        return usuarioDB.map(usuarioDBMapper::to).orElse(null);
    }

    @Override
    public UsuarioEntity findByEmail(String email) {
        Optional<UsuarioDB> usuarioDB = usuarioDBRepository.findByEmail(email);
        return usuarioDB.map(usuarioDBMapper::to).orElse(null);
    }

    @Override
    public UsuarioEntity createAndUpdate(UsuarioEntity usuarioEntity) {
        UsuarioDB usuarioDB;

        try {
            usuarioDB = usuarioDBRepository.save(usuarioDBMapper.from(usuarioEntity));
        } catch (Exception e) {
            throw new RepositoryException();
        }

        return usuarioDBMapper.to(usuarioDB);
    }

    @Override
    public void deleteById(Long id) {
        usuarioDBRepository.deleteById(id);
    }
}
