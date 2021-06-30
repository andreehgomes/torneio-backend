package br.com.pardalzada.torneioapi.entrypoints.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.pardalzada.torneioapi.core.entities.CampeonatoEntity;
import br.com.pardalzada.torneioapi.core.interfaces.campeonato.CampeonatoCreateUseCase;
import br.com.pardalzada.torneioapi.core.interfaces.campeonato.CampeonatoFindAllUseCase;
import br.com.pardalzada.torneioapi.core.interfaces.campeonato.CampeonatoFindByAssociacaoDBUseCase;
import br.com.pardalzada.torneioapi.dataproviders.models.AssociacaoDB;
import br.com.pardalzada.torneioapi.entrypoints.entities.CampeonatoHttp;
import br.com.pardalzada.torneioapi.entrypoints.mappers.CampeonatoHttpMapper;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/campeonato")
@RequiredArgsConstructor
@Log4j2
public class CampeonatoResource {
	
	private final CampeonatoHttpMapper campeonatoHttpMapper;
	
	private final CampeonatoFindAllUseCase campeonatoFindAllUseCase;
	private final CampeonatoCreateUseCase campeonatoCreateUseCase;
	private final CampeonatoFindByAssociacaoDBUseCase campeonatoFindByAssociacaoDBUseCase;
	
	
	@ApiOperation(value = "Listar todos os campeonatos")
	@GetMapping
	public List<CampeonatoHttp> findAll(){
		List<CampeonatoEntity> campeonatoEntityList = campeonatoFindAllUseCase.findAll();
		log.info("Lista de campeonatos gerada com sucesso");
		return campeonatoHttpMapper.fromList(campeonatoEntityList);
	}
	
	@ApiOperation(value = "Listar campeonatos por associacao")
	@GetMapping("/associacao")
	public List<CampeonatoHttp> findByAssociacaoDB(@RequestHeader HttpHeaders httpHeaders){
		Gson gson = new Gson();
		AssociacaoDB associacaoDB = gson.fromJson(httpHeaders.get("associacao").get(0), AssociacaoDB.class);
		List<CampeonatoEntity> campeonatoEntityList = campeonatoFindByAssociacaoDBUseCase.findByAssociacaoDB(associacaoDB);
		log.info("Lista de campeonatos gerada com sucesso");
		return campeonatoHttpMapper.fromList(campeonatoEntityList);		
	}
	
	@ApiOperation(value = "Criar novo campeonato")
	@PostMapping
	public ResponseEntity<CampeonatoHttp> create(@Valid @RequestBody CampeonatoHttp campeonatoHttp){
		CampeonatoEntity campeonatoEntity = campeonatoCreateUseCase.create(campeonatoHttpMapper.to(campeonatoHttp));
		log.info("Campeonato criado com sucesso");
		return ResponseEntity.status(HttpStatus.CREATED).body(campeonatoHttpMapper.from(campeonatoEntity));
		
	}
	
	

}
