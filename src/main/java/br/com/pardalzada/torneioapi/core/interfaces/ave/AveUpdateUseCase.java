package br.com.pardalzada.torneioapi.core.interfaces.ave;

import br.com.pardalzada.torneioapi.core.entities.AveEntity;

public interface AveUpdateUseCase {

    AveEntity update(Long id, AveEntity aveEntity);
}
