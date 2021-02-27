package br.com.pardalzada.torneioapi.dataproviders.interfaces;

import br.com.pardalzada.torneioapi.core.entities.AssociacaoEntity;

import java.util.List;

public interface AssociacaoDBPort {

    List<AssociacaoEntity> findAll();

    AssociacaoEntity findById(Long id);

    AssociacaoEntity findByCnpj(String cnpj);

    AssociacaoEntity createAndUpdate(AssociacaoEntity associacaoEntity);

    void deleteById(Long id);
}
