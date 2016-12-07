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
@Table(name = "juridica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Juridica.findAll", query = "SELECT j FROM Juridica j")
    , @NamedQuery(name = "Juridica.findByCodJuridica", query = "SELECT j FROM Juridica j WHERE j.codJuridica = :codJuridica")
    , @NamedQuery(name = "Juridica.findByRazaoSocial", query = "SELECT j FROM Juridica j WHERE j.razaoSocial = :razaoSocial")
    , @NamedQuery(name = "Juridica.findByNomeFantasia", query = "SELECT j FROM Juridica j WHERE j.nomeFantasia = :nomeFantasia")
    , @NamedQuery(name = "Juridica.findByCnpj", query = "SELECT j FROM Juridica j WHERE j.cnpj = :cnpj")
    , @NamedQuery(name = "Juridica.findByInscricaoMunicipal", query = "SELECT j FROM Juridica j WHERE j.inscricaoMunicipal = :inscricaoMunicipal")})
public class Juridica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_juridica")
    private Integer codJuridica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "razao_social")
    private String razaoSocial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nome_fantasia")
    private String nomeFantasia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "cnpj")
    private String cnpj;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "inscricao_municipal")
    private String inscricaoMunicipal;
    @OneToMany(mappedBy = "codfkJuridica")
    private Collection<Prestador> prestadorCollection;

    public Juridica() {
    }

    public Juridica(Integer codJuridica) {
        this.codJuridica = codJuridica;
    }

    public Juridica(Integer codJuridica, String razaoSocial, String nomeFantasia, String cnpj, String inscricaoMunicipal) {
        this.codJuridica = codJuridica;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    public Integer getCodJuridica() {
        return codJuridica;
    }

    public void setCodJuridica(Integer codJuridica) {
        this.codJuridica = codJuridica;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public void setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
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
        hash += (codJuridica != null ? codJuridica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Juridica)) {
            return false;
        }
        Juridica other = (Juridica) object;
        if ((this.codJuridica == null && other.codJuridica != null) || (this.codJuridica != null && !this.codJuridica.equals(other.codJuridica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.data.entity.Juridica[ codJuridica=" + codJuridica + " ]";
    }
    
}
