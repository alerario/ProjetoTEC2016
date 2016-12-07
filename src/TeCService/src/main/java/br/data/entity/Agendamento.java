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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ricardo
 */
@Entity
@Table(name = "agendamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agendamento.findAll", query = "SELECT a FROM Agendamento a")
    , @NamedQuery(name = "Agendamento.findByCodAgendamento", query = "SELECT a FROM Agendamento a WHERE a.codAgendamento = :codAgendamento")
    , @NamedQuery(name = "Agendamento.findByDia", query = "SELECT a FROM Agendamento a WHERE a.dia = :dia")
    , @NamedQuery(name = "Agendamento.findByMes", query = "SELECT a FROM Agendamento a WHERE a.mes = :mes")
    , @NamedQuery(name = "Agendamento.findByAno", query = "SELECT a FROM Agendamento a WHERE a.ano = :ano")
    , @NamedQuery(name = "Agendamento.findByHoras", query = "SELECT a FROM Agendamento a WHERE a.horas = :horas")
    , @NamedQuery(name = "Agendamento.findByMinutos", query = "SELECT a FROM Agendamento a WHERE a.minutos = :minutos")
    , @NamedQuery(name = "Agendamento.findByDuracao", query = "SELECT a FROM Agendamento a WHERE a.duracao = :duracao")
    , @NamedQuery(name = "Agendamento.findByDescricao", query = "SELECT a FROM Agendamento a WHERE a.descricao = :descricao")})
public class Agendamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_agendamento")
    private Integer codAgendamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "dia")
    private String dia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "mes")
    private String mes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ano")
    private String ano;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "horas")
    private String horas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "minutos")
    private String minutos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "duracao")
    private String duracao;
    @Size(max = 150)
    @Column(name = "descricao")
    private String descricao;
    @JoinColumn(name = "codfk_servico", referencedColumnName = "cod_servico")
    @ManyToOne(optional = false)
    private Servico codfkServico;

    public Agendamento() {
    }

    public Agendamento(Integer codAgendamento) {
        this.codAgendamento = codAgendamento;
    }

    public Agendamento(Integer codAgendamento, String dia, String mes, String ano, String horas, String minutos, String duracao) {
        this.codAgendamento = codAgendamento;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.horas = horas;
        this.minutos = minutos;
        this.duracao = duracao;
    }

    public Integer getCodAgendamento() {
        return codAgendamento;
    }

    public void setCodAgendamento(Integer codAgendamento) {
        this.codAgendamento = codAgendamento;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getHoras() {
        return horas;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }

    public String getMinutos() {
        return minutos;
    }

    public void setMinutos(String minutos) {
        this.minutos = minutos;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Servico getCodfkServico() {
        return codfkServico;
    }

    public void setCodfkServico(Servico codfkServico) {
        this.codfkServico = codfkServico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codAgendamento != null ? codAgendamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agendamento)) {
            return false;
        }
        Agendamento other = (Agendamento) object;
        if ((this.codAgendamento == null && other.codAgendamento != null) || (this.codAgendamento != null && !this.codAgendamento.equals(other.codAgendamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.data.entity.Agendamento[ codAgendamento=" + codAgendamento + " ]";
    }
    
}
