package br.com.pardalzada.torneioapi.dataproviders.interfaces;

import br.com.pardalzada.torneioapi.core.entities.CriadorEntity;
import br.com.pardalzada.torneioapi.dataproviders.models.AssociacaoDB;

import java.util.List;

public interface CriadorDBPort {

    List<CriadorEntity> findAll();

    CriadorEntity findById(Long id);

    CriadorEntity findByCpf(String cpf);

    CriadorEntity createAndUpdate(CriadorEntity criadorEntity);    

    void deleteById(Long id);

	List<CriadorEntity> findByAssociacaoDB(AssociacaoDB associacaoDB);
	
	List<CriadorEntity> findByAssociacaoDBAndAceiteAssociacao(AssociacaoDB associacaoDB, Boolean aceiteAssociacao);
}
