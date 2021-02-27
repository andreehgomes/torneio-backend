package br.com.pardalzada.torneioapi.entrypoints.controllers;

import br.com.pardalzada.torneioapi.core.entities.AssociacaoEntity;
import br.com.pardalzada.torneioapi.core.interfaces.associacao.*;
import br.com.pardalzada.torneioapi.entrypoints.entities.AssociacaoHttp;
import br.com.pardalzada.torneioapi.entrypoints.mappers.AssociacaoHttpMapper;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/associacao")
@RequiredArgsConstructor
@Log4j2
public class AssociacaoResource {

    private final AssociacaoHttpMapper associacaoHttpMapper;

    private final AssociacaoFindAllUseCase associacaoFindAllUseCase;
    private final AssociacaoFindByIdUseCase associacaoFindByIdUseCase;
    private final AssociacaoFindByCnpjUseCase associacaoFindByCnpjUseCase;
    private final AssociacaoCreateUseCase associacaoCreateUseCase;
    private final AssociacaoUpdateUseCase associacaoUpdateUseCase;
    private final AssociacaoDeleteByIdUseCase associacaoDeleteByIdUseCase;

    @ApiOperation(value = "Listar todas associações")
    @GetMapping
    public List<AssociacaoHttp> findAll() {
        List<AssociacaoEntity> associacaoEntityList = associacaoFindAllUseCase.findAll();
        log.info("Lista de associações gerada com sucesso");
        return associacaoHttpMapper.fromList(associacaoEntityList);
    }

    @ApiOperation(value = "Listar associação conforme o ID informado")
    @GetMapping("/{id}")
    public ResponseEntity<AssociacaoHttp> findById(@PathVariable Long id) {
        AssociacaoEntity associacaoEntity = associacaoFindByIdUseCase.findById(id);
        log.info("Associação com o ID {} encontrada com sucesso", associacaoEntity.getCodigo());
        return ResponseEntity.status(HttpStatus.OK).body(associacaoHttpMapper.from(associacaoEntity));
    }
    
    @ApiOperation(value = "Listar associação conforme o CNPJ informado")
    @GetMapping("/busca/{cnpj}")
    public ResponseEntity<AssociacaoHttp> findByCnpj(@PathVariable String cnpj) {
        AssociacaoEntity associacaoEntity = associacaoFindByCnpjUseCase.findByCnpj(cnpj);
        log.info("Associação com o CNPJ {} encontrada com sucesso", associacaoEntity.getCodigo());
        return ResponseEntity.status(HttpStatus.OK).body(associacaoHttpMapper.from(associacaoEntity));
    }

    @ApiOperation(value = "Criar nova associação")
    @PostMapping
    public ResponseEntity<AssociacaoHttp> create(@Valid @RequestBody AssociacaoHttp associacaoHttp) {
        AssociacaoEntity associacaoEntity = associacaoCreateUseCase.create(associacaoHttpMapper.to(associacaoHttp));
        log.info("Associação criada com sucesso");
        return ResponseEntity.status(HttpStatus.CREATED).body(associacaoHttpMapper.from(associacaoEntity));
    }

    @ApiOperation(value = "Atualizar associação conforme o ID informado")
    @PutMapping("/{id}")
    public ResponseEntity<AssociacaoHttp> update(@PathVariable Long id, @Valid @RequestBody AssociacaoHttp associacaoHttp) {
        AssociacaoEntity associacaoEntity = associacaoUpdateUseCase.update(id, associacaoHttpMapper.to(associacaoHttp));
        log.info("Associação com o ID {} atualizada com sucesso", associacaoEntity.getCodigo());
        return ResponseEntity.status(HttpStatus.OK).body(associacaoHttpMapper.from(associacaoEntity));
    }

    @ApiOperation(value = "Deletar associação conforme o ID informado")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        log.info("Associação com o ID {} deletada com sucesso", id);
        associacaoDeleteByIdUseCase.deleteById(id);
    }
}
