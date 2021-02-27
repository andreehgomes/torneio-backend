package br.com.pardalzada.torneioapi.core.interfaces.criador;

import br.com.pardalzada.torneioapi.core.entities.CriadorEntity;

public interface CriadorCreateUseCase {

    CriadorEntity create(CriadorEntity  criadorEntity);
}
