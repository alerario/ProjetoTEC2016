/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.entity;

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
 * @author Rafael
 */
@Entity
@Table(name = "site_empresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "site_empresa.findAll", query = "SELECT se FROM site_empresa se")
    , @NamedQuery(name = "site_empresa.findByservico", query = "SELECT se FROM site_empresa se WHERE se.cod_servico = :codServico")
    , @NamedQuery(name = "site_empresa.findByprestadora", query = "SELECT se FROM site_empresa se WHERE se.cod_prestadora = :codPrestadora")
     , @NamedQuery(name = "site_empresa.findValor", query = "SELECT  s.valor FROM site_empresa se, servico s WHERE se.cod_servico = s.cod_servico")})
public class siteEmpresa {
     private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull

    @JoinColumn(name = "cod_servico", referencedColumnName = "cod_servico")
    @ManyToOne
    private Cliente codServico;
    @JoinColumn(name = "cod_prestador", referencedColumnName = "cod_prestador")
    @ManyToOne
    private Servico codPrestador;
    @Column(name = "valor")
    private Integer valor;

    /**
     * @return the codServico
     */
    public Cliente getCodServico() {
        return codServico;
    }

    /**
     * @param codServico the codServico to set
     */
    public void setCodServico(Cliente codServico) {
        this.codServico = codServico;
    }

    /**
     * @return the codPrestador
     */
    public Servico getCodPrestador() {
        return codPrestador;
    }

    /**
     * @param codPrestador the codPrestador to set
     */
    public void setCodPrestador(Servico codPrestador) {
        this.codPrestador = codPrestador;
    }

    /**
     * @return the valor
     */
    public Integer getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Integer valor) {
        this.valor = valor;
    }
}
