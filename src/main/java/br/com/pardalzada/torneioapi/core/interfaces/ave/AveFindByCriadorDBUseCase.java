package br.com.pardalzada.torneioapi.core.interfaces.ave;

import java.util.List;

import br.com.pardalzada.torneioapi.core.entities.AveEntity;
import br.com.pardalzada.torneioapi.dataproviders.models.CriadorDB;

public interface AveFindByCriadorDBUseCase {

	List<AveEntity> findByCriadorDB(CriadorDB criadorDB);
	
}
