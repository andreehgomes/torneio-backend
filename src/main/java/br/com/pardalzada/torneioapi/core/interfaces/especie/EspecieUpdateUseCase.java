package br.com.pardalzada.torneioapi.core.interfaces.especie;

import br.com.pardalzada.torneioapi.core.entities.EspecieEntity;

public interface EspecieUpdateUseCase {

    EspecieEntity update(Long id, EspecieEntity especieEntity);
}
