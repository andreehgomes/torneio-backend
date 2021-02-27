package br.com.pardalzada.torneioapi.core.interfaces.especie;

import br.com.pardalzada.torneioapi.core.entities.EspecieEntity;

import java.util.List;

public interface EspecieFindAllUseCase {

    List<EspecieEntity> findAll();
}
