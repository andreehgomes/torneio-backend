package br.com.pardalzada.torneioapi.core.interfaces.especie;

import br.com.pardalzada.torneioapi.core.entities.EspecieEntity;

public interface EspecieFindByIdUseCase {

    EspecieEntity findById(Long id);
}
