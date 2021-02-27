package br.com.pardalzada.torneioapi.dataproviders.mappers;

import br.com.pardalzada.torneioapi.core.entities.AssociacaoEntity;
import br.com.pardalzada.torneioapi.core.entities.EnderecoEntity;
import br.com.pardalzada.torneioapi.dataproviders.models.AssociacaoDB;
import br.com.pardalzada.torneioapi.dataproviders.models.EnderecoDB;
import br.com.pardalzada.torneioapi.service.FromToMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AssociacaoDBMapper extends FromToMapper<AssociacaoDB, AssociacaoEntity> {

    private final UsuarioDBMapper usuarioDBMapper;

    @Override
    protected AssociacaoDB fromNonNull(AssociacaoEntity associacaoEntity) {
        EnderecoDB enderecoDB = EnderecoDB.builder()
                .bairro(associacaoEntity.getEnderecoEntity().getBairro())
                .cep(associacaoEntity.getEnderecoEntity().getCep())
                .cidade(associacaoEntity.getEnderecoEntity().getCidade())
                .complemento(associacaoEntity.getEnderecoEntity().getComplemento())
                .estado(associacaoEntity.getEnderecoEntity().getEstado())
                .logradouro(associacaoEntity.getEnderecoEntity().getLogradouro())
                .numero(associacaoEntity.getEnderecoEntity().getNumero())
                .build();

        return AssociacaoDB.builder()
                .codigo(associacaoEntity.getCodigo())
                .cnpj(associacaoEntity.getCnpj())
                .nome(associacaoEntity.getNome())
                .sigla(associacaoEntity.getSigla())
                .enderecoDB(enderecoDB)
                .usuarioDB(usuarioDBMapper.fromNonNull(associacaoEntity.getUsuarioEntity()))
                .build();
    }

    @Override
    protected AssociacaoEntity toNonNull(AssociacaoDB associacaoDB) {
        EnderecoEntity enderecoEntity = EnderecoEntity.builder()
                .bairro(associacaoDB.getEnderecoDB().getBairro())
                .cep(associacaoDB.getEnderecoDB().getCep())
                .cidade(associacaoDB.getEnderecoDB().getCidade())
                .complemento(associacaoDB.getEnderecoDB().getComplemento())
                .estado(associacaoDB.getEnderecoDB().getEstado())
                .logradouro(associacaoDB.getEnderecoDB().getLogradouro())
                .numero(associacaoDB.getEnderecoDB().getNumero())
                .build();

        return AssociacaoEntity.builder()
                .codigo(associacaoDB.getCodigo())
                .cnpj(associacaoDB.getCnpj())
                .nome(associacaoDB.getNome())
                .sigla(associacaoDB.getSigla())
                .enderecoEntity(enderecoEntity)
                .usuarioEntity(usuarioDBMapper.toNonNull(associacaoDB.getUsuarioDB()))
                .build();
    }
}
