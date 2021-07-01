package br.com.pardalzada.torneioapi.entrypoints.mappers;

import org.springframework.stereotype.Component;

import br.com.pardalzada.torneioapi.core.entities.CampeonatoEntity;
import br.com.pardalzada.torneioapi.entrypoints.entities.CampeonatoHttp;
import br.com.pardalzada.torneioapi.service.FromToMapper;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CampeonatoHttpMapper extends FromToMapper<CampeonatoHttp, CampeonatoEntity> {
	private final AssociacaoHttpMapper associacaoHttpMapper;

	@Override
	protected CampeonatoHttp fromNonNull(CampeonatoEntity campeonatoEntity) {
		return  CampeonatoHttp.builder()
				.codigo(campeonatoEntity.getCodigo())
				.nome(campeonatoEntity.getNome())
				.associacaoHttp(associacaoHttpMapper.fromNonNull(campeonatoEntity.getAssociacaoEntity()))
				.build();
	}

	@Override
	protected CampeonatoEntity toNonNull(CampeonatoHttp campeonatoHttp) {
		return CampeonatoEntity.builder()
				.codigo(campeonatoHttp.getCodigo())
				.nome(campeonatoHttp.getNome())
				.associacaoEntity(associacaoHttpMapper.toNonNull(campeonatoHttp.getAssociacaoHttp()))
				.build();
	}

}
