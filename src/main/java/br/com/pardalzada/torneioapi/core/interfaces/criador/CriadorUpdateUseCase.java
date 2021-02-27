package br.com.pardalzada.torneioapi.core.interfaces.criador;

import br.com.pardalzada.torneioapi.core.entities.CriadorEntity;

public interface CriadorUpdateUseCase {

    CriadorEntity update(Long id, CriadorEntity criadorEntity);
}
