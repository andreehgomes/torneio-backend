package br.com.pardalzada.torneioapi.dataproviders.impl;

import br.com.pardalzada.torneioapi.core.entities.PermissaoEntity;
import br.com.pardalzada.torneioapi.dataproviders.interfaces.PermissaoDBPort;
import br.com.pardalzada.torneioapi.dataproviders.mappers.PermissaoDBMapper;
import br.com.pardalzada.torneioapi.dataproviders.models.PermissaoDB;
import br.com.pardalzada.torneioapi.dataproviders.repositories.PermissaoDBRepository;
import br.com.pardalzada.torneioapi.exceptions.ListResourceEmptyException;
import br.com.pardalzada.torneioapi.exceptions.RepositoryException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PermissaoDBPortImp implements PermissaoDBPort {

    private final PermissaoDBMapper permissaoDBMapper;
    private final PermissaoDBRepository permissaoDBRepository;

    @Override
    public List<PermissaoEntity> findAll() {
        List<PermissaoDB> permissaoDBList = permissaoDBRepository.findAll();

        if (!permissaoDBList.isEmpty()) {
            return permissaoDBMapper.toList(permissaoDBList);
        } else {
            throw new ListResourceEmptyException();
        }
    }

    @Override
    public PermissaoEntity findById(Long id) {
        Optional<PermissaoDB> permissaoDB = permissaoDBRepository.findById(id);
        return permissaoDB.map(permissaoDBMapper::to).orElse(null);
    }

    @Override
    public PermissaoEntity findByNome(String nome) {
        Optional<PermissaoDB> permissaoDB = permissaoDBRepository.findByNome(nome);
        return permissaoDB.map(permissaoDBMapper::to).orElse(null);
    }

    @Override
    public PermissaoEntity createAndUpdate(PermissaoEntity permissaoEntity) {
        PermissaoDB permissaoDB;

        try {
            permissaoDB = permissaoDBRepository.save(permissaoDBMapper.from(permissaoEntity));
        } catch (Exception e) {
            throw new RepositoryException();
        }

        return permissaoDBMapper.to(permissaoDB);
    }

    @Override
    public void deleteById(Long id) {
        permissaoDBRepository.deleteById(id);
    }
}
