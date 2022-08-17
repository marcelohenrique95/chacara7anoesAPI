package br.com.chacara.entity;

import javax.persistence.*;

@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    @Column(name = "endereco_id")
    private Long id;

    @OneToOne( mappedBy = "endereco" )
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
