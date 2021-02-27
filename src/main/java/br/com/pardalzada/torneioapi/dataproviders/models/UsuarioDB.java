package br.com.pardalzada.torneioapi.dataproviders.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_usuario")
public class UsuarioDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "senha", nullable = false)
    private String senha;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @ManyToMany
    @JoinTable(name = "tb_usuario_permissao", joinColumns = @JoinColumn(name = "usuario_codigo"),
                                              inverseJoinColumns = @JoinColumn(name = "permissao_codigo"))
    private List<PermissaoDB> permissoes;

    @OneToOne(mappedBy = "usuarioDB")
    private CriadorDB criadorDB;

    @OneToOne(mappedBy = "usuarioDB")
    private AssociacaoDB associacaoDB;
}
