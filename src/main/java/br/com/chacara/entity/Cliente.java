package br.com.chacara.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private Long id;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "cpf")
    private Long cpf;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "email")
    private String email;

    @OneToOne
    @JoinColumn(name = "endereco_id", referencedColumnName = "endereco_id")
    private Endereco endereco;

    @OneToMany(mappedBy = "cliente")
    private List<Reserva> reserva;

}
