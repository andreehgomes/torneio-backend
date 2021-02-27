package br.com.pardalzada.torneioapi.dataproviders.repositories;

import br.com.pardalzada.torneioapi.dataproviders.models.EspecieDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EspecieDBRepository extends JpaRepository<EspecieDB, Long> {

    Optional<EspecieDB> findByNome(String nome);
}
