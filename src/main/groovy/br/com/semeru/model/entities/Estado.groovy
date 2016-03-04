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
@Table(name="estado")
@EqualsAndHashCode
class Estado implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name = "IdEstado", nullable = false)
    Integer idEstado;
    @Column(name = "NomeEstado", nullable = false, length = 40)
    String nomeEstado;
    
    @OneToMany(mappedBy = "estado", fetch = FetchType.LAZY)
    @ForeignKey(name="EnderecoEstado")
    List<Endereco> enderecos;

    Estado() {}
}