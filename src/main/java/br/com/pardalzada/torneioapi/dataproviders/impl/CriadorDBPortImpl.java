package br.com.pardalzada.torneioapi.dataproviders.impl;

import br.com.pardalzada.torneioapi.core.entities.CriadorEntity;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.CriadorDBPort;
import br.com.pardalzada.torneioapi.dataproviders.mappers.CriadorDBMapper;
import br.com.pardalzada.torneioapi.dataproviders.models.AssociacaoDB;
import br.com.pardalzada.torneioapi.dataproviders.models.CriadorDB;
import br.com.pardalzada.torneioapi.dataproviders.repositories.CriadorDBRepository;
import br.com.pardalzada.torneioapi.exceptions.ListResourceEmptyException;
import br.com.pardalzada.torneioapi.exceptions.RepositoryException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CriadorDBPortImpl implements CriadorDBPort {

	private final CriadorDBMapper criadorDBMapper;
	private final CriadorDBRepository criadorDBRepository;

	@Override
	public List<CriadorEntity> findAll() {
		List<CriadorDB> criadorDBList = criadorDBRepository.findAll();

		if (!criadorDBList.isEmpty()) {
			return criadorDBMapper.toList(criadorDBList);
		} else {
			throw new ListResourceEmptyException();
		}
	}

	@Override
	public CriadorEntity findById(Long id) {
		Optional<CriadorDB> criadorDB = criadorDBRepository.findById(id);
		return criadorDB.map(criadorDBMapper::to).orElse(null);
	}

	@Override
	public CriadorEntity findByCpf(String cpf) {
		Optional<CriadorDB> criadorDB = criadorDBRepository.findByCpf(cpf);
		return criadorDB.map(criadorDBMapper::to).orElse(null);
	}

	@Override
	public List<CriadorEntity> findByAssociacaoDB(AssociacaoDB associacaoDB) {
		List<CriadorDB> criadorDBList = criadorDBRepository.findByAssociacaoDB(associacaoDB);
		
		if (!criadorDBList.isEmpty()) {
			return criadorDBMapper.toList(criadorDBList);
		} else {
			throw new ListResourceEmptyException();
		}
	}

	@Override
	public CriadorEntity createAndUpdate(CriadorEntity criadorEntity) {
		CriadorDB criadorDB;

		try {
			criadorDB = criadorDBRepository.save(criadorDBMapper.from(criadorEntity));
		} catch (Exception e) {
			throw new RepositoryException();
		}

		return criadorDBMapper.to(criadorDB);
	}

	@Override
	public void deleteById(Long id) {
		criadorDBRepository.deleteById(id);
	}

}
