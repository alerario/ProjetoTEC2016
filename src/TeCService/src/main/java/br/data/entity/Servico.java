/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
 * @author diegopn_pereira
 */
@Entity
@Table(name = "servico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servico.findAll", query = "SELECT s FROM Servico s")
    , @NamedQuery(name = "Servico.findByCodServico", query = "SELECT s FROM Servico s WHERE s.codServico = :codServico")
    , @NamedQuery(name = "Servico.findByDescricao", query = "SELECT s FROM Servico s WHERE s.descricao = :descricao")
    , @NamedQuery(name = "Servico.findByValor", query = "SELECT s FROM Servico s WHERE s.valor = :valor")
    , @NamedQuery(name = "Servico.findByPropostaCliente", query = "SELECT s FROM Servico s WHERE s.propostaCliente = :propostaCliente")
    , @NamedQuery(name = "Servico.findByPropostaFornecedor", query = "SELECT s FROM Servico s WHERE s.propostaFornecedor = :propostaFornecedor")
    , @NamedQuery(name = "Servico.findByIntervaloCliente", query = "SELECT s FROM Servico s WHERE s.intervaloCliente = :intervaloCliente")
    , @NamedQuery(name = "Servico.findByIntervaloFornecedor", query = "SELECT s FROM Servico s WHERE s.intervaloFornecedor = :intervaloFornecedor")
    , @NamedQuery(name = "Servico.findByStatusNegociacao", query = "SELECT s FROM Servico s WHERE s.statusNegociacao = :statusNegociacao")})
public class Servico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_servico")
    private Integer codServico;
    @Size(max = 250)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private float valor;
    @Size(max = 100)
    @Column(name = "proposta_cliente")
    private String propostaCliente;
    @Size(max = 100)
    @Column(name = "proposta_fornecedor")
    private String propostaFornecedor;
    @Size(max = 100)
    @Column(name = "intervalo_cliente")
    private String intervaloCliente;
    @Size(max = 100)
    @Column(name = "intervalo_fornecedor")
    private String intervaloFornecedor;
    @Column(name = "status_negociacao")
    private Boolean statusNegociacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codfkServico")
    private Collection<Agenda> agendamentoCollection;

    public Servico() {
    }

    public Servico(Integer codServico) {
        this.codServico = codServico;
    }

    public Servico(Integer codServico, float valor) {
        this.codServico = codServico;
        this.valor = valor;
    }

    public Integer getCodServico() {
        return codServico;
    }

    public void setCodServico(Integer codServico) {
        this.codServico = codServico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getPropostaCliente() {
        return propostaCliente;
    }

    public void setPropostaCliente(String propostaCliente) {
        this.propostaCliente = propostaCliente;
    }

    public String getPropostaFornecedor() {
        return propostaFornecedor;
    }

    public void setPropostaFornecedor(String propostaFornecedor) {
        this.propostaFornecedor = propostaFornecedor;
    }

    public String getIntervaloCliente() {
        return intervaloCliente;
    }

    public void setIntervaloCliente(String intervaloCliente) {
        this.intervaloCliente = intervaloCliente;
    }

    public String getIntervaloFornecedor() {
        return intervaloFornecedor;
    }

    public void setIntervaloFornecedor(String intervaloFornecedor) {
        this.intervaloFornecedor = intervaloFornecedor;
    }

    public Boolean getStatusNegociacao() {
        return statusNegociacao;
    }

    public void setStatusNegociacao(Boolean statusNegociacao) {
        this.statusNegociacao = statusNegociacao;
    }

    @XmlTransient
    public Collection<Agenda> getAgendaCollection() {
        return agendamentoCollection;
    }

    public void setAgendaCollection(Collection<Agenda> agendamentoCollection) {
        this.agendamentoCollection = agendamentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codServico != null ? codServico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servico)) {
            return false;
        }
        Servico other = (Servico) object;
        if ((this.codServico == null && other.codServico != null) || (this.codServico != null && !this.codServico.equals(other.codServico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.data.entity.Servico[ codServico=" + codServico + " ]";
    }
    
}
