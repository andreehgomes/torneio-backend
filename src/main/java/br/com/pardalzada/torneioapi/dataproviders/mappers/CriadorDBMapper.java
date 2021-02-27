package br.com.pardalzada.torneioapi.dataproviders.mappers;

import br.com.pardalzada.torneioapi.core.entities.CriadorEntity;
import br.com.pardalzada.torneioapi.core.entities.EnderecoEntity;
import br.com.pardalzada.torneioapi.dataproviders.models.CriadorDB;
import br.com.pardalzada.torneioapi.dataproviders.models.EnderecoDB;
import br.com.pardalzada.torneioapi.service.FromToMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CriadorDBMapper extends FromToMapper<CriadorDB, CriadorEntity> {

    private final AssociacaoDBMapper associacaoDBMapper;
    private final UsuarioDBMapper usuarioDBMapper;

    @Override
    protected CriadorDB fromNonNull(CriadorEntity criadorEntity) {
        EnderecoDB enderecoDB = EnderecoDB.builder()
                .bairro(criadorEntity.getEnderecoEntity().getBairro())
                .cep(criadorEntity.getEnderecoEntity().getCep())
                .cidade(criadorEntity.getEnderecoEntity().getCidade())
                .complemento(criadorEntity.getEnderecoEntity().getComplemento())
                .estado(criadorEntity.getEnderecoEntity().getEstado())
                .logradouro(criadorEntity.getEnderecoEntity().getLogradouro())
                .numero(criadorEntity.getEnderecoEntity().getNumero())
                .build();

        return CriadorDB.builder()
                .codigo(criadorEntity.getCodigo())
                .cpf(criadorEntity.getCpf())
                .ctf(criadorEntity.getCtf())
                .nome(criadorEntity.getNome())
                .rg(criadorEntity.getRg())
                .sobrenome(criadorEntity.getSobrenome())
                .telefone(criadorEntity.getTelefone())
                .ativo(criadorEntity.getAtivo())
                .enderecoDB(enderecoDB)
                .associacaoDB(associacaoDBMapper.fromNonNull(criadorEntity.getAssociacaoEntity()))
                .usuarioDB(usuarioDBMapper.fromNonNull(criadorEntity.getUsuarioEntity()))
                .build();
    }

    @Override
    protected CriadorEntity toNonNull(CriadorDB criadorDB) {
        EnderecoEntity enderecoEntity = EnderecoEntity.builder()
                .bairro(criadorDB.getEnderecoDB().getBairro())
                .cep(criadorDB.getEnderecoDB().getCep())
                .cidade(criadorDB.getEnderecoDB().getCidade())
                .complemento(criadorDB.getEnderecoDB().getComplemento())
                .estado(criadorDB.getEnderecoDB().getEstado())
                .logradouro(criadorDB.getEnderecoDB().getLogradouro())
                .numero(criadorDB.getEnderecoDB().getNumero())
                .build();

        return CriadorEntity.builder()
                .codigo(criadorDB.getCodigo())
                .cpf(criadorDB.getCpf())
                .ctf(criadorDB.getCtf())
                .nome(criadorDB.getNome())
                .rg(criadorDB.getRg())
                .sobrenome(criadorDB.getSobrenome())
                .telefone(criadorDB.getTelefone())
                .ativo(criadorDB.getAtivo())
                .enderecoEntity(enderecoEntity)
                .associacaoEntity(associacaoDBMapper.toNonNull(criadorDB.getAssociacaoDB()))
                .usuarioEntity(usuarioDBMapper.toNonNull(criadorDB.getUsuarioDB()))
                .build();
    }
}
