package br.com.semeru.model.entities;

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

import org.hibernate.annotations.ForeignKey

import groovy.transform.EqualsAndHashCode;

@Entity
@Table(name="cidade")
@EqualsAndHashCode(includes = 'IdCidade')
class Cidade implements Serializable{
    
    private static final long serialVersionUID =  1L; 
    
    @Id
    @GeneratedValue
    @Column(name="IdCidade", nullable=false)
    Integer idCidade;
    @Column(name="Nome", length=80, nullable=false)
    String nome;

    @OneToMany(mappedBy = "cidade", fetch = FetchType.LAZY)
    @ForeignKey(name="EnderecoCidade")
    List<Endereco> enderecos;
    
    Cidade() {}
}