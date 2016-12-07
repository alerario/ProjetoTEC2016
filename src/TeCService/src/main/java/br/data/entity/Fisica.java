/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ricardo
 */
@Entity
@Table(name = "fisica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fisica.findAll", query = "SELECT f FROM Fisica f")
    , @NamedQuery(name = "Fisica.findByCodFisica", query = "SELECT f FROM Fisica f WHERE f.codFisica = :codFisica")
    , @NamedQuery(name = "Fisica.findByNome", query = "SELECT f FROM Fisica f WHERE f.nome = :nome")
    , @NamedQuery(name = "Fisica.findByCpf", query = "SELECT f FROM Fisica f WHERE f.cpf = :cpf")
    , @NamedQuery(name = "Fisica.findByRg", query = "SELECT f FROM Fisica f WHERE f.rg = :rg")})
public class Fisica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_fisica")
    private Integer codFisica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "cpf")
    private String cpf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "rg")
    private String rg;
    @OneToMany(mappedBy = "codfkFisica")
    private Collection<Cliente> clienteCollection;
    @OneToMany(mappedBy = "codfkFisica")
    private Collection<Prestador> prestadorCollection;

    public Fisica() {
    }

    public Fisica(Integer codFisica) {
        this.codFisica = codFisica;
    }

    public Fisica(Integer codFisica, String nome, String cpf, String rg) {
        this.codFisica = codFisica;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
    }

    public Integer getCodFisica() {
        return codFisica;
    }

    public void setCodFisica(Integer codFisica) {
        this.codFisica = codFisica;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    @XmlTransient
    public Collection<Prestador> getPrestadorCollection() {
        return prestadorCollection;
    }

    public void setPrestadorCollection(Collection<Prestador> prestadorCollection) {
        this.prestadorCollection = prestadorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codFisica != null ? codFisica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fisica)) {
            return false;
        }
        Fisica other = (Fisica) object;
        if ((this.codFisica == null && other.codFisica != null) || (this.codFisica != null && !this.codFisica.equals(other.codFisica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.data.entity.Fisica[ codFisica=" + codFisica + " ]";
    }
    
}
