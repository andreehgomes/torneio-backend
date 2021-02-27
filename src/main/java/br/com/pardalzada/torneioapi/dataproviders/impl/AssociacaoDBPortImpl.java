package br.com.pardalzada.torneioapi.dataproviders.impl;

import br.com.pardalzada.torneioapi.core.entities.AssociacaoEntity;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.AssociacaoDBPort;
import br.com.pardalzada.torneioapi.dataproviders.mappers.AssociacaoDBMapper;
import br.com.pardalzada.torneioapi.dataproviders.models.AssociacaoDB;
import br.com.pardalzada.torneioapi.dataproviders.repositories.AssociacaoDBRepository;
import br.com.pardalzada.torneioapi.exceptions.ListResourceEmptyException;
import br.com.pardalzada.torneioapi.exceptions.RepositoryException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AssociacaoDBPortImpl implements AssociacaoDBPort {

    private final AssociacaoDBMapper associacaoDBMapper;
    private final AssociacaoDBRepository associacaoDBRepository;

    @Override
    public List<AssociacaoEntity> findAll() {
        List<AssociacaoDB> associacaoDBList = associacaoDBRepository.findAll();

        if (!associacaoDBList.isEmpty()) {
            return associacaoDBMapper.toList(associacaoDBList);
        } else {
            throw new ListResourceEmptyException();
        }
    }

    @Override
    public AssociacaoEntity findById(Long id) {
        Optional<AssociacaoDB> associacaoDB = associacaoDBRepository.findById(id);
        return associacaoDB.map(associacaoDBMapper::to).orElse(null);
    }

    @Override
    public AssociacaoEntity findByCnpj(String cnpj) {
        Optional<AssociacaoDB> associacaoDB = associacaoDBRepository.findByCnpj(cnpj);
        return associacaoDB.map(associacaoDBMapper::to).orElse(null);
    }

    @Override
    public AssociacaoEntity createAndUpdate(AssociacaoEntity associacaoEntity) {
        AssociacaoDB associacaoDB;

        try {
            associacaoDB = associacaoDBRepository.save(associacaoDBMapper.from(associacaoEntity));
        } catch (Exception e) {
            throw new RepositoryException();
        }

        return associacaoDBMapper.to(associacaoDB);
    }

    @Override
    public void deleteById(Long id) {
        associacaoDBRepository.deleteById(id);
    }
}
