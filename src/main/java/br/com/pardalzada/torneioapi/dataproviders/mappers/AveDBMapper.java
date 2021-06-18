package br.com.pardalzada.torneioapi.dataproviders.mappers;

import br.com.pardalzada.torneioapi.core.entities.AveEntity;
import br.com.pardalzada.torneioapi.core.entities.CriadorEntity;
import br.com.pardalzada.torneioapi.dataproviders.models.AveDB;
import br.com.pardalzada.torneioapi.dataproviders.models.CriadorDB;
import br.com.pardalzada.torneioapi.entrypoints.entities.CriadorHttp;
import br.com.pardalzada.torneioapi.service.FromToMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AveDBMapper extends FromToMapper<AveDB, AveEntity> {

    private final CriadorDBMapper criadorDBMapper;
    private final EspecieDBMapper especieDBMapper;
    private CriadorEntity criadorEntityAntigo = null;
    private CriadorDB criadorDBAntigo = null;

    @Override
    protected AveDB fromNonNull(AveEntity aveEntity) {
    	criadorEntityAntigo = aveEntity.getCriadorEntityAntigo();
    	
    	if(criadorEntityAntigo == null) {
    		return AveDB.builder()
                    .codigo(aveEntity.getCodigo())
                    .nome(aveEntity.getNome())
                    .numeroAnilha(aveEntity.getNumeroAnilha())
                    .ativo(aveEntity.getAtivo())
                    .criadorDB(criadorDBMapper.fromNonNull(aveEntity.getCriadorEntity()))
                    .especieDB(especieDBMapper.fromNonNull(aveEntity.getEspecieEntity()))
                    .statusTransferencia(aveEntity.getStatusTransferencia())
                    .sexo(aveEntity.getSexo())
                    .build();
    	} else {
    		return AveDB.builder()
                    .codigo(aveEntity.getCodigo())
                    .nome(aveEntity.getNome())
                    .numeroAnilha(aveEntity.getNumeroAnilha())
                    .ativo(aveEntity.getAtivo())
                    .criadorDBAntigo(criadorDBMapper.fromNonNull(aveEntity.getCriadorEntityAntigo()))
                    .criadorDBNovo(criadorDBMapper.fromNonNull(aveEntity.getCriadorEntityNovo()))
                    .especieDB(especieDBMapper.fromNonNull(aveEntity.getEspecieEntity()))
                    .statusTransferencia(aveEntity.getStatusTransferencia())
                    .sexo(aveEntity.getSexo())
                    .build();
    	}
        
    }

    @Override
    protected AveEntity toNonNull(AveDB aveDB) {
    	criadorDBAntigo = aveDB.getCriadorDBAntigo();
    	
    	if(criadorDBAntigo == null) {
    		return AveEntity.builder()
                    .codigo(aveDB.getCodigo())
                    .nome(aveDB.getNome())
                    .numeroAnilha(aveDB.getNumeroAnilha())
                    .ativo(aveDB.getAtivo())
                    .criadorEntity(criadorDBMapper.toNonNull(aveDB.getCriadorDB()))
                    .especieEntity(especieDBMapper.toNonNull(aveDB.getEspecieDB()))
                    .statusTransferencia(aveDB.getStatusTransferencia())
                    .sexo(aveDB.getSexo())
                    .build();
    	} else {
    		return AveEntity.builder()
                    .codigo(aveDB.getCodigo())
                    .nome(aveDB.getNome())
                    .numeroAnilha(aveDB.getNumeroAnilha())
                    .ativo(aveDB.getAtivo())
                    .criadorEntityAntigo(criadorDBMapper.toNonNull(aveDB.getCriadorDBAntigo()))
                    .criadorEntityNovo(criadorDBMapper.toNonNull(aveDB.getCriadorDBNovo()))
                    .especieEntity(especieDBMapper.toNonNull(aveDB.getEspecieDB()))
                    .statusTransferencia(aveDB.getStatusTransferencia())
                    .sexo(aveDB.getSexo())
                    .build();
    	}       
    }
}
