package br.com.pardalzada.torneioapi.core.interfaces.criador;

import br.com.pardalzada.torneioapi.core.entities.CriadorEntity;

public interface CriadorFindByCpfUseCase {

	CriadorEntity findByCpf(String cpf);
	
}
