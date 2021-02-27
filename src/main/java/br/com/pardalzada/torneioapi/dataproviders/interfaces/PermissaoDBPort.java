package br.com.pardalzada.torneioapi.dataproviders.interfaces;

import br.com.pardalzada.torneioapi.core.entities.PermissaoEntity;

import java.util.List;

public interface PermissaoDBPort {

    List<PermissaoEntity> findAll();

    PermissaoEntity findById(Long id);

    PermissaoEntity findByNome(String nome);

    PermissaoEntity createAndUpdate(PermissaoEntity permissaoEntity);

    void deleteById(Long id);
}
