package br.com.pardalzada.torneioapi.dataproviders.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_criador")
public class CriadorDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "sobrenome", nullable = false)
    private String sobrenome;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    @Column(name = "rg", nullable = false, unique = true)
    private String rg;

    @Column(name = "ctf", nullable = false, unique = true)
    private String ctf;

    @Column(name = "ativo", nullable = false)
    private Boolean ativo = true;

    @Embedded
    private EnderecoDB enderecoDB;

    @CreationTimestamp
    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @UpdateTimestamp
    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_codigo", referencedColumnName = "codigo")
    private UsuarioDB usuarioDB;

    @OneToMany(mappedBy = "criadorDB")
    private List<AveDB> aves;

    @ManyToOne
    @JoinColumn(name = "associado_codigo", referencedColumnName = "codigo")
    private AssociacaoDB associacaoDB;
    
    @Column(name = "aceite_associacao")
    private Boolean aceiteAssociacao;
}
