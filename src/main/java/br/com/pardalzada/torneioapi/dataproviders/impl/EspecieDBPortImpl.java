package br.com.pardalzada.torneioapi.dataproviders.impl;

import br.com.pardalzada.torneioapi.core.entities.EspecieEntity;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.EspecieDBPort;
import br.com.pardalzada.torneioapi.dataproviders.mappers.EspecieDBMapper;
import br.com.pardalzada.torneioapi.dataproviders.models.EspecieDB;
import br.com.pardalzada.torneioapi.dataproviders.repositories.EspecieDBRepository;
import br.com.pardalzada.torneioapi.exceptions.ListResourceEmptyException;
import br.com.pardalzada.torneioapi.exceptions.RepositoryException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EspecieDBPortImpl implements EspecieDBPort {

    private final EspecieDBMapper especieDBMapper;
    private final EspecieDBRepository especieDBRepository;

    @Override
    public List<EspecieEntity> findAll() {
        List<EspecieDB> especieDBList = especieDBRepository.findAll();

        if (!especieDBList.isEmpty()) {
            return especieDBMapper.toList(especieDBList);
        } else {
            throw new ListResourceEmptyException();
        }
    }

    @Override
    public EspecieEntity findById(Long id) {
        Optional<EspecieDB> especieDB = especieDBRepository.findById(id);
        return especieDB.map(especieDBMapper::to).orElse(null);
    }

    @Override
    public EspecieEntity findByNome(String nome) {
        Optional<EspecieDB> especieDB = especieDBRepository.findByNome(nome);
        return especieDB.map(especieDBMapper::to).orElse(null);
    }

    @Override
    public EspecieEntity createAndUpdate(EspecieEntity especieEntity) {
        EspecieDB especieDB;

        try {
            especieDB = especieDBRepository.save(especieDBMapper.from(especieEntity));
        } catch (Exception e) {
            throw new RepositoryException();
        }

        return especieDBMapper.to(especieDB);
    }

    @Override
    public void deleteById(Long id) {
        especieDBRepository.deleteById(id);
    }
}
