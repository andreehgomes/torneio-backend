package br.com.pardalzada.torneioapi.dataproviders.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pardalzada.torneioapi.dataproviders.models.AssociacaoDB;
import br.com.pardalzada.torneioapi.dataproviders.models.CampeonatoDB;

@Repository
public interface CampeonatoDBRepository extends JpaRepository<CampeonatoDB, Long> {
	
	List<CampeonatoDB> findByAssociacaoDB(AssociacaoDB associacaoDB);
	
}
