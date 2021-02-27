package br.com.pardalzada.torneioapi.core.interfaces.criador;

import br.com.pardalzada.torneioapi.core.entities.CriadorEntity;

import java.util.List;

public interface CriadorFindAllUseCase {

    List<CriadorEntity> findAll();
}
