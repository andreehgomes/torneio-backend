package br.com.pardalzada.torneioapi.entrypoints.mappers;

import br.com.pardalzada.torneioapi.core.entities.PermissaoEntity;
import br.com.pardalzada.torneioapi.entrypoints.entities.PermissaoHttp;
import br.com.pardalzada.torneioapi.service.FromToMapper;
import org.springframework.stereotype.Component;

@Component
public class PermissaoHttpMapper extends FromToMapper<PermissaoHttp, PermissaoEntity> {

    @Override
    protected PermissaoHttp fromNonNull(PermissaoEntity permissaoEntity) {
        return PermissaoHttp.builder()
                .codigo(permissaoEntity.getCodigo())
                .nome(permissaoEntity.getNome())
                .build();
    }

    @Override
    protected PermissaoEntity toNonNull(PermissaoHttp permissaoHttp) {
        return PermissaoEntity.builder()
                .codigo(permissaoHttp.getCodigo())
                .nome(permissaoHttp.getNome())
                .build();
    }
}
