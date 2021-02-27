package br.com.pardalzada.torneioapi.dataproviders.mappers;

import br.com.pardalzada.torneioapi.core.entities.PermissaoEntity;
import br.com.pardalzada.torneioapi.dataproviders.models.PermissaoDB;
import br.com.pardalzada.torneioapi.service.FromToMapper;
import org.springframework.stereotype.Component;

@Component
public class PermissaoDBMapper extends FromToMapper<PermissaoDB, PermissaoEntity> {

    @Override
    protected PermissaoDB fromNonNull(PermissaoEntity permissaoEntity) {
        return PermissaoDB.builder()
                .codigo(permissaoEntity.getCodigo())
                .nome(permissaoEntity.getNome())
                .build();
    }

    @Override
    protected PermissaoEntity toNonNull(PermissaoDB permissaoDB) {
        return PermissaoEntity.builder()
                .codigo(permissaoDB.getCodigo())
                .nome(permissaoDB.getNome())
                .build();
    }
}
