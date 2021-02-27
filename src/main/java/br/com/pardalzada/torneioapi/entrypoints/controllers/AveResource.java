package br.com.pardalzada.torneioapi.entrypoints.controllers;

import br.com.pardalzada.torneioapi.core.entities.AveEntity;
import br.com.pardalzada.torneioapi.core.interfaces.ave.*;
import br.com.pardalzada.torneioapi.dataproviders.models.CriadorDB;
import br.com.pardalzada.torneioapi.entrypoints.entities.AveHttp;
import br.com.pardalzada.torneioapi.entrypoints.mappers.AveHttpMapper;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.google.gson.Gson;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/ave")
@RequiredArgsConstructor
@Log4j2
public class AveResource {

	private final AveHttpMapper aveHttpMapper;

	private final AveFindAllUseCase aveFindAllUseCase;
	private final AveFindByIdUseCase aveFindByIdUseCase;
	private final AveCreateUseCase aveCreateUseCase;
	private final AveUpdateUseCase aveUpdateUseCase;
	private final AveDeleteByIdUseCase aveDeleteByIdUseCase;
	private final AveFindByCriadorDBUseCase aveFindByCriadorDBUseCase;

	@ApiOperation(value = "Listar todas aves")
	@GetMapping
	public List<AveHttp> findAll() {
		List<AveEntity> aveEntityList = aveFindAllUseCase.findAll();
		log.info("Lista de aves gerada com sucesso");
		return aveHttpMapper.fromList(aveEntityList);
	}

	@ApiOperation(value = "Listar ave conforme o ID informado")
	@GetMapping("/{id}")
	public ResponseEntity<AveHttp> findById(@PathVariable Long id) {
		AveEntity aveEntity = aveFindByIdUseCase.findById(id);
		log.info("Ave com o ID {} encontrada com sucesso", aveEntity.getCodigo());
		return ResponseEntity.status(HttpStatus.OK).body(aveHttpMapper.from(aveEntity));
	}
	
	@ApiOperation(value = "Listar aves pro criador")
	@GetMapping("/criador")
	public List<AveHttp> findByCriadorDB(@RequestHeader HttpHeaders httpHeaders){
		Gson gson = new Gson();
		CriadorDB criadorDB = gson.fromJson(httpHeaders.get("criador").get(0), CriadorDB.class);
		List<AveEntity> aveEntityList = aveFindByCriadorDBUseCase.findByCriadorDB(criadorDB);
		log.info("Lista de aves gerada com sucesso");
		return aveHttpMapper.fromList(aveEntityList);
	}

	@ApiOperation(value = "Criar nova ave")
	@PostMapping
	public ResponseEntity<AveHttp> create(@Valid @RequestBody AveHttp aveHttp) {
		AveEntity aveEntity = aveCreateUseCase.create(aveHttpMapper.to(aveHttp));
		System.out.println("Passou " + aveEntity.getNome());
		log.info("Ave criada com sucesso");
		return ResponseEntity.status(HttpStatus.CREATED).body(aveHttpMapper.from(aveEntity));
	}

	@ApiOperation(value = "Atualizar ave conforme o ID informado")
	@PutMapping("/{id}")
	public ResponseEntity<AveHttp> update(@PathVariable Long id, @Valid @RequestBody AveHttp aveHttp) {
		AveEntity aveEntity = aveUpdateUseCase.update(id, aveHttpMapper.to(aveHttp));
		log.info("Ave com o ID {} atualizada com sucesso", aveEntity.getCodigo());
		return ResponseEntity.status(HttpStatus.OK).body(aveHttpMapper.from(aveEntity));
	}

	@ApiOperation(value = "Deletar ave conforme o ID informado")
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		log.info("Ave com o ID {} deletada com sucesso", id);
		aveDeleteByIdUseCase.deleteById(id);
	}
}
