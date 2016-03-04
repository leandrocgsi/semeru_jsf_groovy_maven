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
@Table(name="tipoendereco")
@EqualsAndHashCode
class TipoEndereco implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "IdTipoEndereco", nullable = false)
    Integer idTipoEndereco;
    @Column(name = "DescricaoTipoEndereco", nullable = false, length = 35)
    String descricaoTipoEndereco;
    
    @OneToMany(mappedBy = "tipoendereco", fetch = FetchType.LAZY)
    @ForeignKey(name="EnderecoTipoEndereco")
    List<Endereco> enderecos;

    TipoEndereco() {}
}