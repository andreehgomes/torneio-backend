package br.com.pardalzada.torneioapi.dataproviders.repositories;

import br.com.pardalzada.torneioapi.dataproviders.models.AssociacaoDB;
import br.com.pardalzada.torneioapi.dataproviders.models.CriadorDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CriadorDBRepository extends JpaRepository<CriadorDB, Long> {

    Optional<CriadorDB> findByCpf(String cpf);
    
    List<CriadorDB> findByAssociacaoDB(AssociacaoDB associacaoDB);
    List<CriadorDB> findByAssociacaoDBAndAceiteAssociacao(AssociacaoDB associacaoDB, Boolean aceiteAssociacao);
}
