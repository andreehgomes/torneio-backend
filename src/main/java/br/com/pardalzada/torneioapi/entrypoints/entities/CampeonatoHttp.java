package br.com.pardalzada.torneioapi.entrypoints.entities;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class CampeonatoHttp {

	@Id
	private Long codigo;
	private String nome;
	private AssociacaoHttp associacaoHttp;
	
}
