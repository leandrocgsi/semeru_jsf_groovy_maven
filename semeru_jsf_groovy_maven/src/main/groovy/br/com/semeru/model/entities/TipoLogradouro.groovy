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
@Table(name="tipologradouro")
@EqualsAndHashCode
class TipoLogradouro implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name = "IdTipoLogradouro", nullable = false)
    Integer idTipoLogradouro;
    @Column(name = "DescricaoTipoLogradouro", nullable = false, length = 40)
    String descricaoTipoLogradouro;
    
    @OneToMany(mappedBy = "tipologradouro", fetch = FetchType.LAZY)
    @ForeignKey(name = "EnderecoTipoLogradouro")
    List<Endereco> enderecos;

    TipoLogradouro() {}
}