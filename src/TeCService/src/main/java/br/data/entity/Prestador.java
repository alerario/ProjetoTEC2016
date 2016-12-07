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
@Table(name = "prestador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prestador.findAll", query = "SELECT p FROM Prestador p")
    , @NamedQuery(name = "Prestador.findByCodPrestador", query = "SELECT p FROM Prestador p WHERE p.codPrestador = :codPrestador")
    , @NamedQuery(name = "Prestador.findByTelefone", query = "SELECT p FROM Prestador p WHERE p.telefone = :telefone")})
public class Prestador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_prestador")
    private Integer codPrestador;
    @Size(max = 50)
    @Column(name = "telefone")
    private String telefone;
    @JoinColumn(name = "codfk_endereco", referencedColumnName = "cod_endereco")
    @ManyToOne
    private Endereco codfkEndereco;
    @JoinColumn(name = "codfk_fisica", referencedColumnName = "cod_fisica")
    @ManyToOne
    private Fisica codfkFisica;
    @JoinColumn(name = "codfk_juridica", referencedColumnName = "cod_juridica")
    @ManyToOne
    private Juridica codfkJuridica;
    @OneToMany(mappedBy = "codPrestador")
    private Collection<Mensagemsuporte> mensagemsuporteCollection;
    @OneToMany(mappedBy = "codfkPrestador")
    private Collection<Servico> servicoCollection;

    public Prestador() {
    }

    public Prestador(Integer codPrestador) {
        this.codPrestador = codPrestador;
    }

    public Integer getCodPrestador() {
        return codPrestador;
    }

    public void setCodPrestador(Integer codPrestador) {
        this.codPrestador = codPrestador;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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

    public Juridica getCodfkJuridica() {
        return codfkJuridica;
    }

    public void setCodfkJuridica(Juridica codfkJuridica) {
        this.codfkJuridica = codfkJuridica;
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
        hash += (codPrestador != null ? codPrestador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prestador)) {
            return false;
        }
        Prestador other = (Prestador) object;
        if ((this.codPrestador == null && other.codPrestador != null) || (this.codPrestador != null && !this.codPrestador.equals(other.codPrestador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.data.entity.Prestador[ codPrestador=" + codPrestador + " ]";
    }
    
}
