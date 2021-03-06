package br.com.pardalzada.torneioapi.core.impl.ave;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.pardalzada.torneioapi.core.entities.AveEntity;
import br.com.pardalzada.torneioapi.core.interfaces.ave.AveFindByCriadorDBUseCase;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.AveDBPort;
import br.com.pardalzada.torneioapi.dataproviders.models.CriadorDB;
import br.com.pardalzada.torneioapi.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AveFindByCriadorDBUseCaseImpl implements AveFindByCriadorDBUseCase {

	private final AveDBPort aveDBPort;

	@Override
	public List<AveEntity> findByCriadorDB(CriadorDB criadorDB) {
		List<AveEntity> aveEntity = aveDBPort.findByCriadorDB(criadorDB);

		if (aveEntity != null) {
			return aveEntity;
		} else {
			throw new ResourceNotFoundException(criadorDB);
		}
	}

	@Override
	public List<AveEntity> findByCriadorDBNovo(CriadorDB criadorDBNovo) {
		List<AveEntity> aveEntity = aveDBPort.findByCriadorDBNovo(criadorDBNovo);

		if (aveEntity != null) {
			return aveEntity;
		} else {
			throw new ResourceNotFoundException(criadorDBNovo);
		}
	}
	
	@Override
	public List<AveEntity> findByCriadorDBAntigo(CriadorDB criadorDBAntigo) {
		List<AveEntity> aveEntity = aveDBPort.findByCriadorDBAntigo(criadorDBAntigo);

		if (aveEntity != null) {
			return aveEntity;
		} else {
			throw new ResourceNotFoundException(criadorDBAntigo);
		}
	}

}
