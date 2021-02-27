package br.com.pardalzada.torneioapi.dataproviders.repositories;

import br.com.pardalzada.torneioapi.dataproviders.models.AveDB;
import br.com.pardalzada.torneioapi.dataproviders.models.CriadorDB;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AveDBRepository extends JpaRepository<AveDB, Long> {

    Optional<AveDB> findByNome(String nome);
    
    List<AveDB> findByCriadorDB(CriadorDB criadorDB);
}
