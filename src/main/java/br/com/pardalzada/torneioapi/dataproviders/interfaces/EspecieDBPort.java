package br.com.pardalzada.torneioapi.dataproviders.interfaces;

import br.com.pardalzada.torneioapi.core.entities.EspecieEntity;

import java.util.List;

public interface EspecieDBPort {

    List<EspecieEntity> findAll();

    EspecieEntity findById(Long id);

    EspecieEntity findByNome(String nome);

    EspecieEntity createAndUpdate(EspecieEntity especieEntity);

    void deleteById(Long id);
}
