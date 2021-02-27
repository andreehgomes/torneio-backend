package br.com.pardalzada.torneioapi.entrypoints.controllers;

import br.com.pardalzada.torneioapi.core.entities.UsuarioEntity;
import br.com.pardalzada.torneioapi.core.interfaces.usuario.*;
import br.com.pardalzada.torneioapi.entrypoints.entities.UsuarioHttp;
import br.com.pardalzada.torneioapi.entrypoints.mappers.UsuarioHttpMapper;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/usuario")
@RequiredArgsConstructor
@Log4j2
public class UsuarioResource {

    private final UsuarioHttpMapper usuarioHttpMapper;

    private final UsuarioFindAllUseCase usuarioFindAllUseCase;
    private final UsuarioFindByIdUseCase usuarioFindByIdUseCase;
    private final UsuarioCreateUseCase usuarioCreateUseCase;
    private final UsuarioUpdateUseCase usuarioUpdateUseCase;
    private final UsuarioDeleteByIdUseCase usuarioDeleteByIdUseCase;

    @ApiOperation(value = "Listar todos os usuários")
    @GetMapping
    public List<UsuarioHttp> findAll() {
        List<UsuarioEntity> usuarioEntityList = usuarioFindAllUseCase.findAll();
        log.info("Lista de usuários gerado com sucesso");
        return usuarioHttpMapper.fromList(usuarioEntityList);
    }

    @ApiOperation(value = "Listar usuário conforme o ID informado")
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioHttp> findById(@PathVariable Long id) {
        UsuarioEntity usuarioEntity = usuarioFindByIdUseCase.findById(id);
        log.info("Usuário com o ID {} foi encontrado com sucesso", usuarioEntity.getCodigo());
        return ResponseEntity.status(HttpStatus.OK).body(usuarioHttpMapper.from(usuarioEntity));
    }

    @ApiOperation(value = "Criar novo usuário")
    @PostMapping
    public ResponseEntity<UsuarioHttp> create(@Valid @RequestBody UsuarioHttp usuarioHttp) {
        UsuarioEntity usuarioEntity = usuarioCreateUseCase.create(usuarioHttpMapper.to(usuarioHttp));
        log.info("O usuário foi criado com sucesso");
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioHttpMapper.from(usuarioEntity));
    }

    @ApiOperation(value = "Atualizar usuário conforme o ID informado")
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioHttp> update(@PathVariable Long id, @Valid @RequestBody UsuarioHttp usuarioHttp) {
        UsuarioEntity usuarioEntity = usuarioUpdateUseCase.update(id, usuarioHttpMapper.to(usuarioHttp));
        log.info("Usuário com o ID {} foi atualizado com sucesso", usuarioEntity.getCodigo());
        return ResponseEntity.status(HttpStatus.OK).body(usuarioHttpMapper.from(usuarioEntity));
    }

    @ApiOperation(value = "Deletar usuário conforme o ID informado")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        log.info("Usuário com o ID {} foi deletado com sucesso", id);
        usuarioDeleteByIdUseCase.deleteById(id);
    }
}
