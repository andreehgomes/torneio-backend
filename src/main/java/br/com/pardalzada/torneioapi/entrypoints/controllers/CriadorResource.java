package br.com.pardalzada.torneioapi.entrypoints.controllers;

import br.com.pardalzada.torneioapi.core.entities.CriadorEntity;
import br.com.pardalzada.torneioapi.core.interfaces.criador.*;
import br.com.pardalzada.torneioapi.dataproviders.models.AssociacaoDB;
import br.com.pardalzada.torneioapi.entrypoints.entities.CriadorHttp;
import br.com.pardalzada.torneioapi.entrypoints.mappers.CriadorHttpMapper;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.google.gson.Gson;

import javax.validation.Valid;

import java.io.Reader;
import java.util.List;

@RestController
@RequestMapping("/api/criador")
@RequiredArgsConstructor
@Log4j2
public class CriadorResource {

    private final CriadorHttpMapper criadorHttpMapper;        
    

    private final CriadorFindAllUseCase criadorFindAllUseCase;
    private final CriadorFindByIdUseCase criadorFindByIdUseCase;
    private final CriadorFindByCpfUseCase criadorFindByCpfUseCase;
    private final CriadorCreateUseCase criadorCreateUseCase;
    private final CriadorUpdateUseCase criadorUpdateUseCase;
    private final CriadorDeleteByIdUseCase criadorDeleteByIdUseCase;
    private final CriadorFindByAssociacaoDBUseCase criadorFindByAssociacaoDBUseCase;

    @ApiOperation(value = "Listar todos os criadores")
    @GetMapping
    public List<CriadorHttp> findAll() {
        List<CriadorEntity> criadorEntityList = criadorFindAllUseCase.findAll();
        log.info("Lista de criadores gerado com sucesso");
        return criadorHttpMapper.fromList(criadorEntityList);
    }
    
    @ApiOperation(value = "Listar criadores por Associação")
    @GetMapping("/associacao")
    public List<CriadorHttp> findByAssociacaoDB(@RequestHeader HttpHeaders httpHeader) {    
    	Gson gson = new Gson();    	
    	AssociacaoDB associacaoDB = gson.fromJson(httpHeader.get("associacao").get(0), AssociacaoDB.class);
    	List<CriadorEntity> criadorEntityList = criadorFindByAssociacaoDBUseCase.findByAssociacaoDB(associacaoDB);
    	log.info("Lista de criadores gerado com sucesso");
    	return criadorHttpMapper.fromList(criadorEntityList);
    }

    @ApiOperation(value = "Listar criador conforme o ID informado")
    @GetMapping("/{id}")
    public ResponseEntity<CriadorHttp> findById(@PathVariable Long id) {
        CriadorEntity criadorEntity = criadorFindByIdUseCase.findById(id);
        log.info("Criador com o ID {} foi encontrado com sucesso", criadorEntity.getCodigo());
        return ResponseEntity.status(HttpStatus.OK).body(criadorHttpMapper.from(criadorEntity));
    }
    
    @ApiOperation(value = "Listar criador conforme o CPF informado")
    @GetMapping("/busca/{cpf}")
    public ResponseEntity<CriadorHttp> findByCpf(@PathVariable String cpf) {
        CriadorEntity criadorEntity = criadorFindByCpfUseCase.findByCpf(cpf);
        log.info("Criador com o ID {} foi encontrado com sucesso", criadorEntity.getCodigo());
        return ResponseEntity.status(HttpStatus.OK).body(criadorHttpMapper.from(criadorEntity));
    }
    

    @ApiOperation(value = "Criar novo criador")
    @PostMapping
    public ResponseEntity<CriadorHttp> create(@Valid @RequestBody CriadorHttp criadorHttp) {
        CriadorEntity criadorEntity = criadorCreateUseCase.create(criadorHttpMapper.to(criadorHttp));
        log.info("O criador foi criado com sucesso");
        return ResponseEntity.status(HttpStatus.CREATED).body(criadorHttpMapper.from(criadorEntity));
    }

    @ApiOperation(value = "Atualizar criador conforme o ID informado")
    @PutMapping("/{id}")
    public ResponseEntity<CriadorHttp> update(@PathVariable Long id, @Valid @RequestBody CriadorHttp criadorHttp) {
        CriadorEntity criadorEntity = criadorUpdateUseCase.update(id, criadorHttpMapper.to(criadorHttp));
        log.info("Criador com o ID {} foi atualizado com sucesso", criadorEntity.getCodigo());
        return ResponseEntity.status(HttpStatus.OK).body(criadorHttpMapper.from(criadorEntity));
    }

    @ApiOperation(value = "Deletar criador conforme o ID informado")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        log.info("Criador com o ID {} foi deletado com sucesso", id);
        criadorDeleteByIdUseCase.deleteById(id);
    }
}
