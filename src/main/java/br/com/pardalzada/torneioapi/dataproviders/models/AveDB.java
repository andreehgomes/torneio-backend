package br.com.pardalzada.torneioapi.dataproviders.models;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_ave")
public class AveDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "medida_anilha", nullable = false)
    private String medidaAnilha;

    @Column(name = "numero_anilha", nullable = false)
    private String numeroAnilha;

    @Column(name = "ativo")
    private Boolean ativo = true;

    @ManyToOne
    @JoinColumn(name = "especie_codigo", referencedColumnName = "codigo")
    private EspecieDB especieDB;

    @ManyToOne
    @JoinColumn(name = "criador_codigo", referencedColumnName = "codigo")
    private CriadorDB criadorDB;
    
    @ManyToOne
    @JoinColumn(name = "criador_codigo_antigo", referencedColumnName = "codigo")
    private CriadorDB criadorDBAntigo;
    
    @ManyToOne
    @JoinColumn(name = "criador_codigo_novo", referencedColumnName = "codigo")
    private CriadorDB criadorDBNovo;
}
