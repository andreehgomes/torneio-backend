package br.com.pardalzada.torneioapi.dataproviders.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pardalzada.torneioapi.dataproviders.models.CampeonatoDB;
import br.com.pardalzada.torneioapi.dataproviders.models.EdicaoDB;

@Repository
public interface EdicaoDBRepository extends JpaRepository<EdicaoDB, Long>{
	
	Optional<EdicaoDB> findById(Long codigo);
	
	List<EdicaoDB> findByCampeonatoDB(CampeonatoDB campeonatoDB);

}
