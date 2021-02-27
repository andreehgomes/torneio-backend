package br.com.pardalzada.torneioapi.entrypoints.controllers;

import br.com.pardalzada.torneioapi.core.entities.EspecieEntity;
import br.com.pardalzada.torneioapi.core.interfaces.especie.*;
import br.com.pardalzada.torneioapi.entrypoints.entities.EspecieHttp;
import br.com.pardalzada.torneioapi.entrypoints.mappers.EspecieHttpMapper;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/especie")
@RequiredArgsConstructor
@Log4j2
public class EspecieResource {

    private final EspecieHttpMapper especieHttpMapper;

    private final EspecieFindAllUseCase especieFindAllUseCase;
    private final EspecieFindByIdUseCase especieFindByIdUseCase;
    private final EspecieCreateUseCase especieCreateUseCase;
    private final EspecieUpdateUseCase especieUpdateUseCase;
    private final EspecieDeleteByIdUseCase especieDeleteByIdUseCase;

    @ApiOperation(value = "Listar todas espécies")
    @GetMapping
    public List<EspecieHttp> findAll() {
        List<EspecieEntity> especieEntityList = especieFindAllUseCase.findAll();
        log.info("Lista de espécies gerada com sucesso");
        return especieHttpMapper.fromList(especieEntityList);
    }

    @ApiOperation(value = "Listar espécie conforme o ID informado")
    @GetMapping("/{id}")
    public ResponseEntity<EspecieHttp> findById(@PathVariable Long id) {
        EspecieEntity especieEntity = especieFindByIdUseCase.findById(id);
        log.info("Espécie com o ID {} encontrada com sucesso", especieEntity.getCodigo());
        return ResponseEntity.status(HttpStatus.OK).body(especieHttpMapper.from(especieEntity));
    }

    @ApiOperation(value = "Criar nova espécie")
    @PostMapping
    public ResponseEntity<EspecieHttp> create(@Valid @RequestBody EspecieHttp especieHttp) {
        EspecieEntity especieEntity = especieCreateUseCase.create(especieHttpMapper.to(especieHttp));
        log.info("Espécie criada com sucesso");
        return ResponseEntity.status(HttpStatus.CREATED).body(especieHttpMapper.from(especieEntity));
    }

    @ApiOperation(value = "Atualizar espécie conforme o ID informado")
    @PutMapping("/{id}")
    public ResponseEntity<EspecieHttp> update(@PathVariable Long id, @Valid @RequestBody EspecieHttp especieHttp) {
        EspecieEntity especieEntity = especieUpdateUseCase.update(id, especieHttpMapper.to(especieHttp));
        log.info("Espécie com o ID {} atualizada com sucesso", especieEntity.getCodigo());
        return ResponseEntity.status(HttpStatus.OK).body(especieHttpMapper.from(especieEntity));
    }

    @ApiOperation(value = "Deletar espécie conforme o ID informado")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        log.info("Espécie com o ID {} deletada com sucesso", id);
        especieDeleteByIdUseCase.deleteById(id);
    }
}
