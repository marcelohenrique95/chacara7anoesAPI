package br.com.chacara.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "endereco_id")
    private Long id;

    @OneToOne(mappedBy = "endereco")
    private Cliente cliente;

    @Column(name = "bairro", length = 50)
    private String bairro;

    @Column(name = "rua")
    private String rua;

    @Column(name = "cep", nullable = false)
    private Long cep;

    @Column(name = "numero", length = 4)
    private Long numero;

    @Column(name = "complemento", length = 100)
    private String complemento;
}
