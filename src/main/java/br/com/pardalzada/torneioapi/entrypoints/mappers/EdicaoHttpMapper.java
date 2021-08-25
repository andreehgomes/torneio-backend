package br.com.pardalzada.torneioapi.entrypoints.mappers;

import org.springframework.stereotype.Component;

import br.com.pardalzada.torneioapi.core.entities.EdicaoEntity;
import br.com.pardalzada.torneioapi.entrypoints.entities.EdicaoHttp;
import br.com.pardalzada.torneioapi.service.FromToMapper;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EdicaoHttpMapper extends FromToMapper<EdicaoHttp, EdicaoEntity> {
	
	private final CampeonatoHttpMapper campeonatoHttpMapper;
	
	@Override
	protected EdicaoHttp fromNonNull(EdicaoEntity edicaoEntity) {
		return EdicaoHttp.builder()
				.codigo(edicaoEntity.getCodigo())
				.nome(edicaoEntity.getNome())
				.campeonatoHttp(campeonatoHttpMapper.fromNonNull(edicaoEntity.getCampeonatoEntity()))
				.build();
	}

	@Override
	protected EdicaoEntity toNonNull(EdicaoHttp edicaoHttp) {
		return EdicaoEntity.builder()
				.codigo(edicaoHttp.getCodigo())
				.nome(edicaoHttp.getNome())
				.campeonatoEntity(campeonatoHttpMapper.toNonNull(edicaoHttp.getCampeonatoHttp()))
				.build();
	}

}
