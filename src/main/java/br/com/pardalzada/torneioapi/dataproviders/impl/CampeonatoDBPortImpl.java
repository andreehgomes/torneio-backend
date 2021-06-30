package br.com.pardalzada.torneioapi.dataproviders.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.pardalzada.torneioapi.core.entities.CampeonatoEntity;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.CampeonatoDBPort;
import br.com.pardalzada.torneioapi.dataproviders.mappers.CampeonatoDBMapper;
import br.com.pardalzada.torneioapi.dataproviders.models.AssociacaoDB;
import br.com.pardalzada.torneioapi.dataproviders.models.CampeonatoDB;
import br.com.pardalzada.torneioapi.dataproviders.repositories.CampeonatoDBRepository;
import br.com.pardalzada.torneioapi.exceptions.ListResourceEmptyException;
import br.com.pardalzada.torneioapi.exceptions.RepositoryException;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CampeonatoDBPortImpl implements CampeonatoDBPort{
	
	private final CampeonatoDBMapper campeonatoDBMapper;
	private final CampeonatoDBRepository campeonatoDBRepository;
	
	@Override
	public List<CampeonatoEntity> findAll(){
		List<CampeonatoDB> campeonatoDBList = campeonatoDBRepository.findAll();
		
		if(!campeonatoDBList.isEmpty()) {
			return campeonatoDBMapper.toList(campeonatoDBList);
		} else {
			throw new ListResourceEmptyException();
		}
	}

	@Override
	public CampeonatoEntity createAndUpdate(CampeonatoEntity campeonatoEntity) {
		CampeonatoDB campeonatoDB;
		
		try {
			campeonatoDB = campeonatoDBRepository.save(campeonatoDBMapper.from(campeonatoEntity));
		} catch (Exception e) {
			throw new RepositoryException();
		}
		
		return campeonatoDBMapper.to(campeonatoDB);
	}

	@Override
	public List<CampeonatoEntity> findByAssociacaoDB(AssociacaoDB associacaoDB) {
		List<CampeonatoDB> campeonatoDBList = campeonatoDBRepository.findByAssociacaoDB(associacaoDB);
		
		if(!campeonatoDBList.isEmpty()) {
			return campeonatoDBMapper.toList(campeonatoDBList);
		}else {
			throw new ListResourceEmptyException();
		}
	}

}
