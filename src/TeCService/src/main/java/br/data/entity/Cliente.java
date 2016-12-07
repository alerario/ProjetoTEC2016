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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByCodCliente", query = "SELECT c FROM Cliente c WHERE c.codCliente = :codCliente")
    , @NamedQuery(name = "Cliente.findByTelefone", query = "SELECT c FROM Cliente c WHERE c.telefone = :telefone")
    , @NamedQuery(name = "Cliente.findByCpf", query = "SELECT c FROM Cliente c WHERE c.cpf = :cpf")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_cliente")
    private Integer codCliente;
    @Size(max = 100)
    @Column(name = "telefone")
    private String telefone;
    @Size(max = 100)
    @Column(name = "cpf")
    private String cpf;
    @OneToMany(mappedBy = "codCliente")
    private Collection<Clienteservico> clienteservicoCollection;
    @JoinColumn(name = "codfk_endereco", referencedColumnName = "cod_endereco")
    @ManyToOne
    private Endereco codfkEndereco;
    @JoinColumn(name = "codfk_fisica", referencedColumnName = "cod_fisica")
    @ManyToOne
    private Fisica codfkFisica;
    @OneToMany(mappedBy = "codCliente")
    private Collection<Mensagemsuporte> mensagemsuporteCollection;
    @OneToMany(mappedBy = "codfkCliente")
    private Collection<Servico> servicoCollection;

    public Cliente() {
    }

    public Cliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public Integer getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @XmlTransient
    public Collection<Clienteservico> getClienteservicoCollection() {
        return clienteservicoCollection;
    }

    public void setClienteservicoCollection(Collection<Clienteservico> clienteservicoCollection) {
        this.clienteservicoCollection = clienteservicoCollection;
    }

    public Endereco getCodfkEndereco() {
        return codfkEndereco;
    }

    public void setCodfkEndereco(Endereco codfkEndereco) {
        this.codfkEndereco = codfkEndereco;
    }

    public Fisica getCodfkFisica() {
        return codfkFisica;
    }

    public void setCodfkFisica(Fisica codfkFisica) {
        this.codfkFisica = codfkFisica;
    }

    @XmlTransient
    public Collection<Mensagemsuporte> getMensagemsuporteCollection() {
        return mensagemsuporteCollection;
    }

    public void setMensagemsuporteCollection(Collection<Mensagemsuporte> mensagemsuporteCollection) {
        this.mensagemsuporteCollection = mensagemsuporteCollection;
    }

    @XmlTransient
    public Collection<Servico> getServicoCollection() {
        return servicoCollection;
    }

    public void setServicoCollection(Collection<Servico> servicoCollection) {
        this.servicoCollection = servicoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCliente != null ? codCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.codCliente == null && other.codCliente != null) || (this.codCliente != null && !this.codCliente.equals(other.codCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.data.entity.Cliente[ codCliente=" + codCliente + " ]";
    }
    
}
