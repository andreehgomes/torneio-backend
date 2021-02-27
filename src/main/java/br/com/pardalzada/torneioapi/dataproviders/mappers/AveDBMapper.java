package br.com.pardalzada.torneioapi.dataproviders.mappers;

import br.com.pardalzada.torneioapi.core.entities.AveEntity;
import br.com.pardalzada.torneioapi.dataproviders.models.AveDB;
import br.com.pardalzada.torneioapi.service.FromToMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AveDBMapper extends FromToMapper<AveDB, AveEntity> {

    private final CriadorDBMapper criadorDBMapper;
    private final EspecieDBMapper especieDBMapper;

    @Override
    protected AveDB fromNonNull(AveEntity aveEntity) {
        return AveDB.builder()
                .codigo(aveEntity.getCodigo())
                .nome(aveEntity.getNome())
                .medidaAnilha(aveEntity.getMedidaAnilha())
                .numeroAnilha(aveEntity.getNumeroAnilha())
                .ativo(aveEntity.getAtivo())
                .criadorDB(criadorDBMapper.fromNonNull(aveEntity.getCriadorEntity()))
                .especieDB(especieDBMapper.fromNonNull(aveEntity.getEspecieEntity()))
                .build();
    }

    @Override
    protected AveEntity toNonNull(AveDB aveDB) {
        return AveEntity.builder()
                .codigo(aveDB.getCodigo())
                .nome(aveDB.getNome())
                .medidaAnilha(aveDB.getMedidaAnilha())
                .numeroAnilha(aveDB.getNumeroAnilha())
                .ativo(aveDB.getAtivo())
                .criadorEntity(criadorDBMapper.toNonNull(aveDB.getCriadorDB()))
                .especieEntity(especieDBMapper.toNonNull(aveDB.getEspecieDB()))
                .build();
    }
}
