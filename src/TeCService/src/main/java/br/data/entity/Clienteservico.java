/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ricardo
 */
@Entity
@Table(name = "clienteservico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clienteservico.findAll", query = "SELECT c FROM Clienteservico c")
    , @NamedQuery(name = "Clienteservico.findByCodClienteservico", query = "SELECT c FROM Clienteservico c WHERE c.codClienteservico = :codClienteservico")
    , @NamedQuery(name = "Clienteservico.findByQuantidade", query = "SELECT c FROM Clienteservico c WHERE c.quantidade = :quantidade")})
public class Clienteservico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_clienteservico")
    private Integer codClienteservico;
    @Column(name = "quantidade")
    private Integer quantidade;
    @JoinColumn(name = "cod_cliente", referencedColumnName = "cod_cliente")
    @ManyToOne
    private Cliente codCliente;
    @JoinColumn(name = "cod_servico", referencedColumnName = "cod_servico")
    @ManyToOne
    private Servico codServico;

    public Clienteservico() {
    }

    public Clienteservico(Integer codClienteservico) {
        this.codClienteservico = codClienteservico;
    }

    public Integer getCodClienteservico() {
        return codClienteservico;
    }

    public void setCodClienteservico(Integer codClienteservico) {
        this.codClienteservico = codClienteservico;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Cliente getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Cliente codCliente) {
        this.codCliente = codCliente;
    }

    public Servico getCodServico() {
        return codServico;
    }

    public void setCodServico(Servico codServico) {
        this.codServico = codServico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codClienteservico != null ? codClienteservico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clienteservico)) {
            return false;
        }
        Clienteservico other = (Clienteservico) object;
        if ((this.codClienteservico == null && other.codClienteservico != null) || (this.codClienteservico != null && !this.codClienteservico.equals(other.codClienteservico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.data.entity.Clienteservico[ codClienteservico=" + codClienteservico + " ]";
    }
    
}
