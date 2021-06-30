package br.com.pardalzada.torneioapi.dataproviders.mappers;

import org.springframework.stereotype.Component;

import br.com.pardalzada.torneioapi.core.entities.CampeonatoEntity;
import br.com.pardalzada.torneioapi.dataproviders.models.CampeonatoDB;
import br.com.pardalzada.torneioapi.service.FromToMapper;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CampeonatoDBMapper extends FromToMapper<CampeonatoDB, CampeonatoEntity> {
	
	private final AssociacaoDBMapper associacaoDBMapper;
	
	@Override
	protected CampeonatoDB fromNonNull(CampeonatoEntity campeonatoEntity) {
		return CampeonatoDB.builder()
				.codigo(campeonatoEntity.getCodigo())
				.nome(campeonatoEntity.getNome())
				.edicao(campeonatoEntity.getEdicao())
				.associacaoDB(associacaoDBMapper.fromNonNull(campeonatoEntity.getAssociacaoEntity()))
				.build();
	}

	@Override
	protected CampeonatoEntity toNonNull(CampeonatoDB campeonatoDB) {
		return CampeonatoEntity.builder()
				.codigo(campeonatoDB.getCodigo())
				.nome(campeonatoDB.getNome())
				.edicao(campeonatoDB.getEdicao())
				.associacaoEntity(associacaoDBMapper.toNonNull(campeonatoDB.getAssociacaoDB()))
				.build();
		
	}

}
