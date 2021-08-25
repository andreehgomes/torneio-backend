package br.com.pardalzada.torneioapi.dataproviders.mappers;

import org.springframework.stereotype.Component;

import br.com.pardalzada.torneioapi.core.entities.CampeonatoEntity;
import br.com.pardalzada.torneioapi.core.entities.EdicaoEntity;
import br.com.pardalzada.torneioapi.dataproviders.models.CampeonatoDB;
import br.com.pardalzada.torneioapi.dataproviders.models.EdicaoDB;
import br.com.pardalzada.torneioapi.service.FromToMapper;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EdicaoDBMapper extends FromToMapper<EdicaoDB, EdicaoEntity> {
	
	private final CampeonatoDBMapper campeonatoDBMapper;
	private CampeonatoEntity campeonatoEntity;
	private CampeonatoDB campeonatoDB;
	
	@Override
	protected EdicaoDB fromNonNull(EdicaoEntity edicaoEntity) {
		return EdicaoDB.builder()
				.codigo(edicaoEntity.getCodigo())
				.nome(edicaoEntity.getNome())
				.campeonatoDB(campeonatoDBMapper.fromNonNull(edicaoEntity.getCampeonatoEntity()))
				.build();
	}

	@Override
	protected EdicaoEntity toNonNull(EdicaoDB edicaoDB) {
		return EdicaoEntity.builder()
				.codigo(edicaoDB.getCodigo())
				.nome(edicaoDB.getNome())
				.campeonatoEntity(campeonatoDBMapper.toNonNull(edicaoDB.getCampeonatoDB()))
				.build();
	}

}
