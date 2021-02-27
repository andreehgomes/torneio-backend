package br.com.pardalzada.torneioapi.dataproviders.impl;

import br.com.pardalzada.torneioapi.core.entities.AveEntity;
import br.com.pardalzada.torneioapi.core.entities.CriadorEntity;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.AveDBPort;
import br.com.pardalzada.torneioapi.dataproviders.mappers.AveDBMapper;
import br.com.pardalzada.torneioapi.dataproviders.models.AssociacaoDB;
import br.com.pardalzada.torneioapi.dataproviders.models.AveDB;
import br.com.pardalzada.torneioapi.dataproviders.models.CriadorDB;
import br.com.pardalzada.torneioapi.dataproviders.repositories.AveDBRepository;
import br.com.pardalzada.torneioapi.exceptions.ListResourceEmptyException;
import br.com.pardalzada.torneioapi.exceptions.RepositoryException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AveDBPortImpl implements AveDBPort {

    private final AveDBMapper aveDBMapper;
    private final AveDBRepository aveDBRepository;

    @Override
    public List<AveEntity> findAll() {
        List<AveDB> aveDBList = aveDBRepository.findAll();

        if (!aveDBList.isEmpty()) {
            return aveDBMapper.toList(aveDBList);
        } else {
            throw new ListResourceEmptyException();
        }
    }

    @Override
    public AveEntity findById(Long id) {
        Optional<AveDB> aveDB = aveDBRepository.findById(id);
        return aveDB.map(aveDBMapper::to).orElse(null);
    }

    @Override
    public AveEntity findByNome(String nome) {
        Optional<AveDB> aveDB = aveDBRepository.findByNome(nome);
        return aveDB.map(aveDBMapper::to).orElse(null);
    }
    
    @Override
	public List<AveEntity> findByCriadorDB(CriadorDB criadorDB) {
		List<AveDB> aveDBList = aveDBRepository.findByCriadorDB(criadorDB);
		
		if (!aveDBList.isEmpty()) {
			return aveDBMapper.toList(aveDBList);
		} else {
			throw new ListResourceEmptyException();
		}
	}

    @Override
    public AveEntity createAndUpdate(AveEntity aveEntity) {
        AveDB aveDB;

        try {
            aveDB = aveDBRepository.save(aveDBMapper.from(aveEntity));
        } catch (Exception e) {
            throw new RepositoryException();
        }

        return aveDBMapper.to(aveDB);
    }

    @Override
    public void deleteById(Long id) {
        aveDBRepository.deleteById(id);
    }
}
