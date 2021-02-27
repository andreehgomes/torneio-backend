package br.com.pardalzada.torneioapi.dataproviders.interfaces;

import br.com.pardalzada.torneioapi.core.entities.UsuarioEntity;

import java.util.List;

public interface UsuarioDBPort {

    List<UsuarioEntity> findAll();

    UsuarioEntity findById(Long id);
    
    UsuarioEntity findByEmail(String email);

    UsuarioEntity createAndUpdate(UsuarioEntity usuarioEntity);

    void deleteById(Long id);
}
