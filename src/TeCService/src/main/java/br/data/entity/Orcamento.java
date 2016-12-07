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
 * @author Jéssica
 */
@Entity
@Table(name = "orcamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "orcamento.findAll", query = "SELECT o FROM orcamento o")
    , @NamedQuery(name = "Orcamento.findByCodPrestador", query = "SELECT o FROM Orcamento o WHERE o.codPrestador = :codPrestador")
    , @NamedQuery(name = "Orcamento.findByCodOrcamento", query = "SELECT o FROM Orcamento o WHERE o.codOrcamento = :codOrcamento")})
public class Orcamento implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    
    @Column(name = "cod_orcamento")
    private Integer codOrcamento;
    @Size(max = 50)
    
    @OneToMany(mappedBy = "codfkPrestador")
    private Collection<Prestador> servicoCollection;
    
    @Column(name = "descricao")
    private String descricao;
    
    public Orcamento() {
    }

    public Orcamento(Integer codOrcamento) {
        this.codOrcamento = codOrcamento;
    }
    
    public Integer getCodOrcamento() {
        return codOrcamento;
    }

    public void setCodOrcamento(Integer codOrcamento) {
        this.codOrcamento = codOrcamento;
    }
    
    @XmlTransient
    public Collection<Prestador> getServicoCollection() {
        return servicoCollection;
    }

    public void setServicoCollection(Collection<Prestador> servicoCollection) {
        this.servicoCollection = servicoCollection;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
