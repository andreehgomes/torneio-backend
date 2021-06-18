package br.com.pardalzada.torneioapi.entrypoints.mappers;

import br.com.pardalzada.torneioapi.core.entities.AveEntity;
import br.com.pardalzada.torneioapi.core.entities.CriadorEntity;
import br.com.pardalzada.torneioapi.entrypoints.entities.AveHttp;
import br.com.pardalzada.torneioapi.entrypoints.entities.CriadorHttp;
import br.com.pardalzada.torneioapi.service.FromToMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AveHttpMapper extends FromToMapper<AveHttp, AveEntity> {

    private final EspecieHttpMapper especieHttpMapper;
    private final CriadorHttpMapper criadorHttpMapper;
    private CriadorHttp criadorHttp = null;
    private CriadorEntity criadorEntity = null;
    private CriadorHttp criadorHttpAntigo = null;
    private CriadorEntity criadorEntityAntigo = null;

    @Override
    protected AveHttp fromNonNull(AveEntity aveEntity) {    
    	criadorEntity = aveEntity.getCriadorEntity();
    	criadorEntityAntigo = aveEntity.getCriadorEntityAntigo();    	
    	
    	if(criadorEntityAntigo != null) {
    		return AveHttp.builder()
                    .codigo(aveEntity.getCodigo())
                    .nome(aveEntity.getNome())
                    .numeroAnilha(aveEntity.getNumeroAnilha())
                    .ativo(aveEntity.getAtivo())
                    .especieHttp(especieHttpMapper.fromNonNull(aveEntity.getEspecieEntity()))
                    .criadorHttpAntigo(criadorHttpMapper.fromNonNull(aveEntity.getCriadorEntityAntigo()))
                    .criadorHttpNovo(criadorHttpMapper.fromNonNull(aveEntity.getCriadorEntityNovo()))
                    .statusTransferencia(aveEntity.getStatusTransferencia())
                    .sexo(aveEntity.getSexo())
                    .build();
    	}else {
    		return AveHttp.builder()
                    .codigo(aveEntity.getCodigo())
                    .nome(aveEntity.getNome())
                    .numeroAnilha(aveEntity.getNumeroAnilha())
                    .ativo(aveEntity.getAtivo())
                    .especieHttp(especieHttpMapper.fromNonNull(aveEntity.getEspecieEntity()))
                    .criadorHttp(criadorHttpMapper.fromNonNull(aveEntity.getCriadorEntity()))
                    .statusTransferencia(aveEntity.getStatusTransferencia())
                    .sexo(aveEntity.getSexo())
                    .build();
    	}
    }

    @Override
    protected AveEntity toNonNull(AveHttp aveHttp) {
    	criadorHttp = aveHttp.getCriadorHttp();
    	criadorHttpAntigo = aveHttp.getCriadorHttpAntigo();
    	
    	if(criadorHttpAntigo != null) {
    		return AveEntity.builder()
                    .codigo(aveHttp.getCodigo())
                    .nome(aveHttp.getNome())
                    .numeroAnilha(aveHttp.getNumeroAnilha())
                    .ativo(aveHttp.getAtivo())
                    .especieEntity(especieHttpMapper.toNonNull(aveHttp.getEspecieHttp()))
                    .criadorEntityAntigo(criadorHttpMapper.toNonNull(aveHttp.getCriadorHttpAntigo()))
                    .criadorEntityNovo(criadorHttpMapper.toNonNull(aveHttp.getCriadorHttpNovo()))
                    .statusTransferencia(aveHttp.getStatusTransferencia())
                    .sexo(aveHttp.getSexo())
                    .build();
    	} else {
    		return AveEntity.builder()
                    .codigo(aveHttp.getCodigo())
                    .nome(aveHttp.getNome())
                    .numeroAnilha(aveHttp.getNumeroAnilha())
                    .ativo(aveHttp.getAtivo())
                    .especieEntity(especieHttpMapper.toNonNull(aveHttp.getEspecieHttp()))
                    .criadorEntity(criadorHttpMapper.toNonNull(aveHttp.getCriadorHttp()))
                    .statusTransferencia(aveHttp.getStatusTransferencia())
                    .sexo(aveHttp.getSexo())
                    .build();
    	}
    	
        
    }
}
