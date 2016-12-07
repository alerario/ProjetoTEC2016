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
@Table(name = "endereco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Endereco.findAll", query = "SELECT e FROM Endereco e")
    , @NamedQuery(name = "Endereco.findByCodEndereco", query = "SELECT e FROM Endereco e WHERE e.codEndereco = :codEndereco")
    , @NamedQuery(name = "Endereco.findByRua", query = "SELECT e FROM Endereco e WHERE e.rua = :rua")
    , @NamedQuery(name = "Endereco.findByNumero", query = "SELECT e FROM Endereco e WHERE e.numero = :numero")
    , @NamedQuery(name = "Endereco.findByBairro", query = "SELECT e FROM Endereco e WHERE e.bairro = :bairro")
    , @NamedQuery(name = "Endereco.findByEstado", query = "SELECT e FROM Endereco e WHERE e.estado = :estado")
    , @NamedQuery(name = "Endereco.findByCidade", query = "SELECT e FROM Endereco e WHERE e.cidade = :cidade")})
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_endereco")
    private Integer codEndereco;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "rua")
    private String rua;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "numero")
    private String numero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "bairro")
    private String bairro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "cidade")
    private String cidade;
    @OneToMany(mappedBy = "codfkEndereco")
    private Collection<Cliente> clienteCollection;
    @OneToMany(mappedBy = "codfkEndereco")
    private Collection<Prestador> prestadorCollection;

    public Endereco() {
    }

    public Endereco(Integer codEndereco) {
        this.codEndereco = codEndereco;
    }

    public Endereco(Integer codEndereco, String rua, String numero, String bairro, String estado, String cidade) {
        this.codEndereco = codEndereco;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.estado = estado;
        this.cidade = cidade;
    }

    public Integer getCodEndereco() {
        return codEndereco;
    }

    public void setCodEndereco(Integer codEndereco) {
        this.codEndereco = codEndereco;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
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
        hash += (codEndereco != null ? codEndereco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Endereco)) {
            return false;
        }
        Endereco other = (Endereco) object;
        if ((this.codEndereco == null && other.codEndereco != null) || (this.codEndereco != null && !this.codEndereco.equals(other.codEndereco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.data.entity.Endereco[ codEndereco=" + codEndereco + " ]";
    }
    
}
