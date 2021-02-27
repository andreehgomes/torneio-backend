package br.com.pardalzada.torneioapi.dataproviders.mappers;

import br.com.pardalzada.torneioapi.core.entities.EspecieEntity;
import br.com.pardalzada.torneioapi.dataproviders.models.EspecieDB;
import br.com.pardalzada.torneioapi.service.FromToMapper;
import org.springframework.stereotype.Component;

@Component
public class EspecieDBMapper extends FromToMapper<EspecieDB, EspecieEntity> {

    @Override
    protected EspecieDB fromNonNull(EspecieEntity especieEntity) {
        return EspecieDB.builder()
                .codigo(especieEntity.getCodigo())
                .nome(especieEntity.getNome())
                .nomeCientifico(especieEntity.getNomeCientifico())
                .build();
    }

    @Override
    protected EspecieEntity toNonNull(EspecieDB especieDB) {
        return EspecieEntity.builder()
                .codigo(especieDB.getCodigo())
                .nome(especieDB.getNome())
                .nomeCientifico(especieDB.getNomeCientifico())
                .build();
    }
}
