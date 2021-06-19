package br.com.pardalzada.torneioapi.core.impl.criador;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.pardalzada.torneioapi.core.entities.CriadorEntity;
import br.com.pardalzada.torneioapi.core.interfaces.criador.CriadorFindByAssociacaoDBUseCase;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.CriadorDBPort;
import br.com.pardalzada.torneioapi.dataproviders.models.AssociacaoDB;
import br.com.pardalzada.torneioapi.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CriadorFindByAssociacaoDBUseCaseImpl implements CriadorFindByAssociacaoDBUseCase {
	
	private final CriadorDBPort criadorDBPort;
	
	@Override
	public List<CriadorEntity> findByAssociacaoDB(AssociacaoDB associacaoDB) {
		List<CriadorEntity> criadorEntity = criadorDBPort.findByAssociacaoDB(associacaoDB);
		
		if (criadorEntity != null) {
            return criadorEntity;
        } else {
            throw new ResourceNotFoundException(associacaoDB);
        }
	}

	@Override
	public List<CriadorEntity> frinByAssociacaoDBAndaceiteAssociacao(AssociacaoDB associacaoDB, Boolean aceiteAssociacao) {
		List<CriadorEntity> criadorEntity = criadorDBPort.findByAssociacaoDBAndAceiteAssociacao(associacaoDB, aceiteAssociacao);
		
		if (criadorEntity != null) {
            return criadorEntity;
        } else {
            throw new ResourceNotFoundException(associacaoDB);
        }
		
	}
	
	

}
