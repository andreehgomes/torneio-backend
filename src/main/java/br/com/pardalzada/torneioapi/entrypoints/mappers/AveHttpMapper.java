package br.com.pardalzada.torneioapi.entrypoints.mappers;

import br.com.pardalzada.torneioapi.core.entities.AveEntity;
import br.com.pardalzada.torneioapi.entrypoints.entities.AveHttp;
import br.com.pardalzada.torneioapi.service.FromToMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AveHttpMapper extends FromToMapper<AveHttp, AveEntity> {

    private final EspecieHttpMapper especieHttpMapper;
    private final CriadorHttpMapper criadorHttpMapper;

    @Override
    protected AveHttp fromNonNull(AveEntity aveEntity) {
        return AveHttp.builder()
                .codigo(aveEntity.getCodigo())
                .nome(aveEntity.getNome())
                .medidaAnilha(aveEntity.getMedidaAnilha())
                .numeroAnilha(aveEntity.getNumeroAnilha())
                .ativo(aveEntity.getAtivo())
                .especieHttp(especieHttpMapper.fromNonNull(aveEntity.getEspecieEntity()))
                .criadorHttp(criadorHttpMapper.fromNonNull(aveEntity.getCriadorEntity()))
                .build();
    }

    @Override
    protected AveEntity toNonNull(AveHttp aveHttp) {
        return AveEntity.builder()
                .codigo(aveHttp.getCodigo())
                .nome(aveHttp.getNome())
                .medidaAnilha(aveHttp.getMedidaAnilha())
                .numeroAnilha(aveHttp.getNumeroAnilha())
                .ativo(aveHttp.getAtivo())
                .especieEntity(especieHttpMapper.toNonNull(aveHttp.getEspecieHttp()))
                .criadorEntity(criadorHttpMapper.toNonNull(aveHttp.getCriadorHttp()))
                .build();
    }
}
