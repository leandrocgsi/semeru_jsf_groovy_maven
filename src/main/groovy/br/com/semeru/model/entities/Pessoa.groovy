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
import javax.persistence.Temporal

import org.hibernate.annotations.ForeignKey

import groovy.transform.EqualsAndHashCode;

@Entity
@Table (name="pessoa")
@EqualsAndHashCode
class Pessoa implements Serializable {
    
    private static final long serialVersionUID =  1L;
    
    @Id
    @GeneratedValue
    @Column(name="IdPessoa", nullable=false)
    Integer idPessoa;
    @Column (name="Name", nullable = false, length = 80 )
    String nome;
    @Column (name="Email", nullable = false, length = 80 )
    String email;
    @Column (name="Telefone", nullable = false, length = 16 )//(034)-98888-8888
    String telefone;
    @Column (name="CPF", nullable = false, length = 14 )
    String cpf;
    @Column (name="DataDeNascimento", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dataDeNascimento;
    @Column (name="DataDeCadastro", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dataDeCadastro;
        
    @Column(name = "Login", unique=true, length = 25)
    String login;
    @Column(name = "Senha", length = 40)
    String senha;
    @Column(name = "Permissao", length = 36)
    String permissao;
    
    @OneToOne(mappedBy = "pessoa", fetch = FetchType.LAZY)
    @ForeignKey(name="EnderecoPessoa")
    Endereco endereco;
    
    @ManyToOne(optional=false)
    @ForeignKey(name = "PessoaSexo") 
    @JoinColumn(name="IdSexo", referencedColumnName = "IdSexo")
    Sexo sexo;

    Pessoa() {
        this.sexo = new Sexo();
    }     
}