package br.com.pardalzada.torneioapi.dataproviders.interfaces;

import br.com.pardalzada.torneioapi.core.entities.AveEntity;
import br.com.pardalzada.torneioapi.dataproviders.models.CriadorDB;

import java.util.List;

public interface AveDBPort {

    List<AveEntity> findAll();

    AveEntity findById(Long id);

    AveEntity findByNome(String nome);

    AveEntity createAndUpdate(AveEntity aveEntity);

    void deleteById(Long id);

	List<AveEntity> findByCriadorDB(CriadorDB criadorDB);
}
