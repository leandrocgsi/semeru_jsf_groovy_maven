package br.com.semeru.model.entities;

import groovy.transform.EqualsAndHashCode

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

import org.hibernate.annotations.ForeignKey

@Entity
@Table(name="sexo")
@EqualsAndHashCode
class Sexo implements Serializable {
    
    private static final long serialVersionUID =  1L;   
    
    @Id
    @GeneratedValue
    @Column(name="IdSexo",nullable=false)
    Integer idSexo;
    @Column(name="Descricao", unique=true, nullable=false, length=9)
    String descricao;

    @OneToMany(mappedBy = "sexo", fetch = FetchType.LAZY)
    @ForeignKey(name = "PessoaSexo")        
    List<Pessoa> pessoas;
    
    Sexo() {}
}