package br.com.pardalzada.torneioapi.entrypoints.mappers;

import br.com.pardalzada.torneioapi.core.entities.EspecieEntity;
import br.com.pardalzada.torneioapi.entrypoints.entities.EspecieHttp;
import br.com.pardalzada.torneioapi.service.FromToMapper;
import org.springframework.stereotype.Component;

@Component
public class EspecieHttpMapper extends FromToMapper<EspecieHttp, EspecieEntity> {

    @Override
    protected EspecieHttp fromNonNull(EspecieEntity especieEntity) {
        return EspecieHttp.builder()
                .codigo(especieEntity.getCodigo())
                .nome(especieEntity.getNome())
                .nomeCientifico(especieEntity.getNomeCientifico())
                .build();
    }

    @Override
    protected EspecieEntity toNonNull(EspecieHttp especieHttp) {
        return EspecieEntity.builder()
                .codigo(especieHttp.getCodigo())
                .nome(especieHttp.getNome())
                .nomeCientifico(especieHttp.getNomeCientifico())
                .build();
    }
}
