package br.com.pardalzada.torneioapi.dataproviders.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.pardalzada.torneioapi.core.entities.EdicaoEntity;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.EdicaoDBPort;
import br.com.pardalzada.torneioapi.dataproviders.mappers.EdicaoDBMapper;
import br.com.pardalzada.torneioapi.dataproviders.models.CampeonatoDB;
import br.com.pardalzada.torneioapi.dataproviders.models.EdicaoDB;
import br.com.pardalzada.torneioapi.dataproviders.repositories.EdicaoDBRepository;
import br.com.pardalzada.torneioapi.exceptions.RepositoryException;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EdicaoDBPortImpl implements EdicaoDBPort {
	
	private final EdicaoDBMapper edicaoDBMapper;
	private final EdicaoDBRepository edicaoDBRepository;
	
	@Override
	public List<EdicaoEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EdicaoEntity findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EdicaoEntity findByNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EdicaoEntity createAndUpdate(EdicaoEntity edicaoEntity) {
		EdicaoDB edicaoDB;
		
		try {
			edicaoDB = edicaoDBRepository.save(edicaoDBMapper.from(edicaoEntity));
		} catch (Exception e) {
			throw new RepositoryException();
		}
		
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EdicaoEntity> findByCampeonatoDB(CampeonatoDB campeonatoDB) {
		// TODO Auto-generated method stub
		return null;
	}

}
