package br.com.pardalzada.torneioapi.entrypoints.controllers;

import br.com.pardalzada.torneioapi.core.entities.PermissaoEntity;
import br.com.pardalzada.torneioapi.core.interfaces.permissao.*;
import br.com.pardalzada.torneioapi.entrypoints.entities.PermissaoHttp;
import br.com.pardalzada.torneioapi.entrypoints.mappers.PermissaoHttpMapper;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/permissao")
@RequiredArgsConstructor
@Log4j2
public class PermissaoResource {

    private final PermissaoHttpMapper permissaoHttpMapper;

    private final PermissaoFindAllUseCase permissaoFindAllUseCase;
    private final PermissaoFindByIdUseCase permissaoFindByIdUseCase;
    private final PermissaoCreateUseCase permissaoCreateUseCase;
    private final PermissaoUpdateUseCase permissaoUpdateUseCase;
    private final PermissaoDeleteByIdUseCase permissaoDeleteByIdUseCase;

    @ApiOperation(value = "Listar todas permissões")
    @GetMapping
    public List<PermissaoHttp> findAll() {
        List<PermissaoEntity> permissaoEntityList = permissaoFindAllUseCase.findAll();
        log.info("Lista de permissões gerada com sucesso");
        return permissaoHttpMapper.fromList(permissaoEntityList);
    }

    @ApiOperation(value = "Listar permissão conforme o ID informado")
    @GetMapping("/{id}")
    public ResponseEntity<PermissaoHttp> findById(@PathVariable Long id) {
        PermissaoEntity permissaoEntity = permissaoFindByIdUseCase.findById(id);
        log.info("Permissão com o ID {} encontrada com sucesso", permissaoEntity.getCodigo());
        return ResponseEntity.status(HttpStatus.OK).body(permissaoHttpMapper.from(permissaoEntity));
    }

    @ApiOperation(value = "Criar nova permissão")
    @PostMapping
    public ResponseEntity<PermissaoHttp> create(@Valid @RequestBody PermissaoHttp permissaoHttp) {
        PermissaoEntity permissaoEntity = permissaoCreateUseCase.create(permissaoHttpMapper.to(permissaoHttp));
        log.info("Permissão criada com sucesso");
        return ResponseEntity.status(HttpStatus.CREATED).body(permissaoHttpMapper.from(permissaoEntity));
    }

    @ApiOperation(value = "Atualizar permissão conforme o ID informado")
    @PutMapping("/{id}")
    public ResponseEntity<PermissaoHttp> update(@PathVariable Long id, @Valid @RequestBody PermissaoHttp permissaoHttp) {
        PermissaoEntity permissaoEntity = permissaoUpdateUseCase.update(id, permissaoHttpMapper.to(permissaoHttp));
        log.info("Permissão com o ID {} atualizada com sucesso", permissaoEntity.getCodigo());
        return ResponseEntity.status(HttpStatus.OK).body(permissaoHttpMapper.from(permissaoEntity));
    }

    @ApiOperation(value = "Deletar permissão conforme o ID informado")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        log.info("Permissão com o ID {} deletada com sucesso", id);
        permissaoDeleteByIdUseCase.deleteById(id);
    }
}
