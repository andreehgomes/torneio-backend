package br.com.pardalzada.torneioapi.entrypoints.mappers;

import br.com.pardalzada.torneioapi.core.entities.AssociacaoEntity;
import br.com.pardalzada.torneioapi.core.entities.EnderecoEntity;
import br.com.pardalzada.torneioapi.entrypoints.entities.AssociacaoHttp;
import br.com.pardalzada.torneioapi.entrypoints.entities.EnderecoHttp;
import br.com.pardalzada.torneioapi.service.FromToMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AssociacaoHttpMapper extends FromToMapper<AssociacaoHttp, AssociacaoEntity> {

    private final UsuarioHttpMapper usuarioHttpMapper;

    @Override
    protected AssociacaoHttp fromNonNull(AssociacaoEntity associacaoEntity) {
        EnderecoHttp enderecoHttp = EnderecoHttp.builder()
                .bairro(associacaoEntity.getEnderecoEntity().getBairro())
                .cep(associacaoEntity.getEnderecoEntity().getCep())
                .cidade(associacaoEntity.getEnderecoEntity().getCidade())
                .complemento(associacaoEntity.getEnderecoEntity().getComplemento())
                .estado(associacaoEntity.getEnderecoEntity().getEstado())
                .logradouro(associacaoEntity.getEnderecoEntity().getLogradouro())
                .numero(associacaoEntity.getEnderecoEntity().getNumero())
                .build();

        return AssociacaoHttp.builder()
                .codigo(associacaoEntity.getCodigo())
                .cnpj(associacaoEntity.getCnpj())
                .nome(associacaoEntity.getNome())
                .sigla(associacaoEntity.getSigla())
                .enderecoHttp(enderecoHttp)
                .usuarioHttp(usuarioHttpMapper.fromNonNull(associacaoEntity.getUsuarioEntity()))
                .build();
    }

    @Override
    protected AssociacaoEntity toNonNull(AssociacaoHttp associacaoHttp) {
        EnderecoEntity enderecoEntity = EnderecoEntity.builder()
                .bairro(associacaoHttp.getEnderecoHttp().getBairro())
                .cep(associacaoHttp.getEnderecoHttp().getCep())
                .cidade(associacaoHttp.getEnderecoHttp().getCidade())
                .complemento(associacaoHttp.getEnderecoHttp().getComplemento())
                .estado(associacaoHttp.getEnderecoHttp().getEstado())
                .logradouro(associacaoHttp.getEnderecoHttp().getLogradouro())
                .numero(associacaoHttp.getEnderecoHttp().getNumero())
                .build();

        return AssociacaoEntity.builder()
                .codigo(associacaoHttp.getCodigo())
                .cnpj(associacaoHttp.getCnpj())
                .nome(associacaoHttp.getNome())
                .sigla(associacaoHttp.getSigla())
                .enderecoEntity(enderecoEntity)
                .usuarioEntity(usuarioHttpMapper.toNonNull(associacaoHttp.getUsuarioHttp()))
                .build();
    }
}
