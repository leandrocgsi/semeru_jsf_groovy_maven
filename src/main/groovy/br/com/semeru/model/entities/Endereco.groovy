package br.com.semeru.model.entities;

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToOne
import javax.persistence.Table

import org.hibernate.annotations.ForeignKey

import groovy.transform.EqualsAndHashCode;

@Entity
@Table(name="endereco")
@EqualsAndHashCode
class Endereco implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name="IdEndereco", nullable=false)
    Integer idEndereco;
    @Column(name="Bairro", length=80)
    String bairro;
    @Column (name="NomeLogradouro", length=80)
    String nomeLogradouro;
    @Column (name="CEP", length=9)
    String cep;
    @Column (name="Numero")
    Integer numero;
    @Column (name="Complemento")
    Integer complemento;
    
    @OneToOne(optional=true, fetch= FetchType.LAZY)
    @ForeignKey(name="EnderecoPessoa")
    @JoinColumn(name = "IdPessoa", referencedColumnName = "IdPessoa")
    Pessoa pessoa;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name="EnderecoTipoLogradouro")
    @JoinColumn(name = "IdTipoLogradouro", referencedColumnName = "IdTipoLogradouro")
    TipoLogradouro tipologradouro;
    
    @ManyToOne(optional=false, fetch = FetchType.LAZY)
    @ForeignKey(name="EnderecoEstado")
    @JoinColumn(name = "IdEstado", nullable = false)
    Estado estado;
        
    @ManyToOne(optional=false, fetch = FetchType.LAZY)
    @ForeignKey(name="EnderecoTipoEndereco")
    @JoinColumn(name = "IdTipoEndereco", referencedColumnName="IdTipoEndereco")
    TipoEndereco tipoendereco;
    
    @ManyToOne(optional=false, fetch = FetchType.LAZY)
    @ForeignKey(name="EnderecoCidade")
    @JoinColumn(name = "IdCidade", referencedColumnName="IdCidade")
    Cidade cidade;   

    Endereco() {
        this.cidade = new Cidade();
        this.estado = new Estado();
        this.tipologradouro = new TipoLogradouro();
        this.tipoendereco = new TipoEndereco();
        this.pessoa = new Pessoa();
    }     
}