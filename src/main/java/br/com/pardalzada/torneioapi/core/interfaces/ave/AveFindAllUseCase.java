package br.com.pardalzada.torneioapi.core.interfaces.ave;

import br.com.pardalzada.torneioapi.core.entities.AveEntity;

import java.util.List;

public interface AveFindAllUseCase {

    List<AveEntity> findAll();
}
