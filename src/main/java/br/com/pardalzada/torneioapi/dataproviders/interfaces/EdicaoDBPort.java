package br.com.pardalzada.torneioapi.dataproviders.interfaces;

import java.util.List;

import br.com.pardalzada.torneioapi.core.entities.EdicaoEntity;
import br.com.pardalzada.torneioapi.dataproviders.models.CampeonatoDB;

public interface EdicaoDBPort {
	
	List<EdicaoEntity> findAll();
	
	EdicaoEntity findById(Long id);

	EdicaoEntity findByNome(String nome);

	EdicaoEntity createAndUpdate(EdicaoEntity edicaoEntity);

    void deleteById(Long id);

	List<EdicaoEntity> findByCampeonatoDB(CampeonatoDB campeonatoDB);
	

}
