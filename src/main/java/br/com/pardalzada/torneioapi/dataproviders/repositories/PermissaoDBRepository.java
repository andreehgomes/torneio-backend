package br.com.pardalzada.torneioapi.dataproviders.repositories;

import br.com.pardalzada.torneioapi.dataproviders.models.PermissaoDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermissaoDBRepository extends JpaRepository<PermissaoDB, Long> {

    Optional<PermissaoDB> findByNome(String nome);
}
