package br.com.pardalzada.torneioapi.core.interfaces.criador;

import br.com.pardalzada.torneioapi.core.entities.CriadorEntity;

public interface CriadorFindByIdUseCase {

    CriadorEntity findById(Long id);
}
