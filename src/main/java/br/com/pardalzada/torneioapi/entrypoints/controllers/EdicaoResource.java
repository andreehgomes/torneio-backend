package br.com.pardalzada.torneioapi.entrypoints.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pardalzada.torneioapi.core.entities.EdicaoEntity;
import br.com.pardalzada.torneioapi.core.interfaces.edicao.EdicaoCreateUseCase;
import br.com.pardalzada.torneioapi.core.interfaces.edicao.EdicaoDeleteByIdUseCase;
import br.com.pardalzada.torneioapi.core.interfaces.edicao.EdicaoFindAllUseCase;
import br.com.pardalzada.torneioapi.core.interfaces.edicao.EdicaoFindByIdUseCase;
import br.com.pardalzada.torneioapi.core.interfaces.edicao.EdicaoUpdateUseCase;
import br.com.pardalzada.torneioapi.entrypoints.entities.EdicaoHttp;
import br.com.pardalzada.torneioapi.entrypoints.mappers.EdicaoHttpMapper;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/edicao")
@RequiredArgsConstructor
@Log4j2
public class EdicaoResource {
	
	private final EdicaoHttpMapper edicaoHttpMapper;
	
	private final EdicaoCreateUseCase edicaoCreateUseCase;
	private final EdicaoFindAllUseCase edicaoFindAllUseCase;
	private final EdicaoFindByIdUseCase edicaoFindByIdUseCase;
	private final EdicaoUpdateUseCase edicaoUpdateUseCase;
	private final EdicaoDeleteByIdUseCase edicaoDeleteByIdUseCase;
	
	@ApiOperation(value = "Adicionar nova edição do campeonato")
	@PostMapping
	public ResponseEntity<EdicaoHttp> create(@Valid @RequestBody EdicaoHttp edicaoHttp){
		EdicaoEntity edicaoEntity = edicaoCreateUseCase.create(edicaoHttpMapper.to(edicaoHttp));
		log.info("Edicao adicionada com sucesso");
		return ResponseEntity.status(HttpStatus.CREATED).body(edicaoHttpMapper.from(edicaoEntity));
	}

}
