package br.com.pardalzada.torneioapi.dataproviders.repositories;

import br.com.pardalzada.torneioapi.dataproviders.models.AssociacaoDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AssociacaoDBRepository extends JpaRepository<AssociacaoDB, Long> {

    Optional<AssociacaoDB> findByCnpj(String cnpj);
}
