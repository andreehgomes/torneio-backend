package br.com.pardalzada.torneioapi.entrypoints.mappers;

import br.com.pardalzada.torneioapi.core.entities.CriadorEntity;
import br.com.pardalzada.torneioapi.core.entities.EnderecoEntity;
import br.com.pardalzada.torneioapi.entrypoints.entities.CriadorHttp;
import br.com.pardalzada.torneioapi.entrypoints.entities.EnderecoHttp;
import br.com.pardalzada.torneioapi.service.FromToMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CriadorHttpMapper extends FromToMapper<CriadorHttp, CriadorEntity> {

    private final AssociacaoHttpMapper associacaoHttpMapper;
    private final UsuarioHttpMapper usuarioHttpMapper;

    @Override
    protected CriadorHttp fromNonNull(CriadorEntity criadorEntity) {
        EnderecoHttp enderecoHttp = EnderecoHttp.builder()
                .bairro(criadorEntity.getEnderecoEntity().getBairro())
                .cep(criadorEntity.getEnderecoEntity().getCep())
                .cidade(criadorEntity.getEnderecoEntity().getCidade())
                .complemento(criadorEntity.getEnderecoEntity().getComplemento())
                .estado(criadorEntity.getEnderecoEntity().getEstado())
                .logradouro(criadorEntity.getEnderecoEntity().getLogradouro())
                .numero(criadorEntity.getEnderecoEntity().getNumero())
                .build();
        
        CriadorHttp criador = null;
        if(criadorEntity.getAssociacaoEntity() != null) {
        	criador =  CriadorHttp.builder()
	                    .codigo(criadorEntity.getCodigo())
	                    .cpf(criadorEntity.getCpf())
	                    .ctf(criadorEntity.getCtf())
	                    .nome(criadorEntity.getNome())
	                    .rg(criadorEntity.getRg())
	                    .sobrenome(criadorEntity.getSobrenome())
	                    .telefone(criadorEntity.getTelefone())
	                    .ativo(criadorEntity.getAtivo())
	                    .enderecoHttp(enderecoHttp)
	                    .associacaoHttp(associacaoHttpMapper.fromNonNull(criadorEntity.getAssociacaoEntity()))
	                    .usuarioHttp(usuarioHttpMapper.fromNonNull(criadorEntity.getUsuarioEntity()))
	                    .aceiteAssociacao(criadorEntity.getAceiteAssociacao())
	                    .build();
        }else {
        	criador =  CriadorHttp.builder()
	                    .codigo(criadorEntity.getCodigo())
	                    .cpf(criadorEntity.getCpf())
	                    .ctf(criadorEntity.getCtf())
	                    .nome(criadorEntity.getNome())
	                    .rg(criadorEntity.getRg())
	                    .sobrenome(criadorEntity.getSobrenome())
	                    .telefone(criadorEntity.getTelefone())
	                    .ativo(criadorEntity.getAtivo())
	                    .enderecoHttp(enderecoHttp)
	                    .usuarioHttp(usuarioHttpMapper.fromNonNull(criadorEntity.getUsuarioEntity()))
	                    .aceiteAssociacao(criadorEntity.getAceiteAssociacao())
	                    .build();        	
        }
        
        return criador;
        
    }

    @Override
    protected CriadorEntity toNonNull(CriadorHttp criadorHttp) {
        EnderecoEntity enderecoEntity = EnderecoEntity.builder()
                .bairro(criadorHttp.getEnderecoHttp().getBairro())
                .cep(criadorHttp.getEnderecoHttp().getCep())
                .cidade(criadorHttp.getEnderecoHttp().getCidade())
                .complemento(criadorHttp.getEnderecoHttp().getComplemento())
                .estado(criadorHttp.getEnderecoHttp().getEstado())
                .logradouro(criadorHttp.getEnderecoHttp().getLogradouro())
                .numero(criadorHttp.getEnderecoHttp().getNumero())
                .build();

        CriadorEntity criador = null;
        if(criadorHttp.getAssociacaoHttp() != null) {
        	criador = CriadorEntity.builder()
                    .codigo(criadorHttp.getCodigo())
                    .cpf(criadorHttp.getCpf())
                    .ctf(criadorHttp.getCtf())
                    .nome(criadorHttp.getNome())
                    .rg(criadorHttp.getRg())
                    .sobrenome(criadorHttp.getSobrenome())
                    .telefone(criadorHttp.getTelefone())
                    .ativo(criadorHttp.getAtivo())
                    .enderecoEntity(enderecoEntity)
                    .associacaoEntity(associacaoHttpMapper.toNonNull(criadorHttp.getAssociacaoHttp()))
                    .usuarioEntity(usuarioHttpMapper.toNonNull(criadorHttp.getUsuarioHttp()))
                    .aceiteAssociacao(criadorHttp.getAceiteAssociacao())
                    .build();
        }else {
        	criador = CriadorEntity.builder()
                    .codigo(criadorHttp.getCodigo())
                    .cpf(criadorHttp.getCpf())
                    .ctf(criadorHttp.getCtf())
                    .nome(criadorHttp.getNome())
                    .rg(criadorHttp.getRg())
                    .sobrenome(criadorHttp.getSobrenome())
                    .telefone(criadorHttp.getTelefone())
                    .ativo(criadorHttp.getAtivo())
                    .enderecoEntity(enderecoEntity)
                    .usuarioEntity(usuarioHttpMapper.toNonNull(criadorHttp.getUsuarioHttp()))
                    .aceiteAssociacao(criadorHttp.getAceiteAssociacao())
                    .build();
        }
        
        return criador;
    }
}
