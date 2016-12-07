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
@Table(name = "usuariomarketing")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuariomarketing.findAll", query = "SELECT u FROM Usuariomarketing u")
    , @NamedQuery(name = "Usuariomarketing.findByCodUsuariomarketing", query = "SELECT u FROM Usuariomarketing u WHERE u.codUsuariomarketing = :codUsuariomarketing")
    , @NamedQuery(name = "Usuariomarketing.findByLogin", query = "SELECT u FROM Usuariomarketing u WHERE u.login = :login")
    , @NamedQuery(name = "Usuariomarketing.findBySenha", query = "SELECT u FROM Usuariomarketing u WHERE u.senha = :senha")
    , @NamedQuery(name = "Usuariomarketing.findByEmail", query = "SELECT u FROM Usuariomarketing u WHERE u.email = :email")})
public class Usuariomarketing implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_usuariomarketing")
    private Integer codUsuariomarketing;
    @Size(max = 40)
    @Column(name = "login")
    private String login;
    @Size(max = 40)
    @Column(name = "senha")
    private String senha;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;

    public Usuariomarketing() {
    }

    public Usuariomarketing(Integer codUsuariomarketing) {
        this.codUsuariomarketing = codUsuariomarketing;
    }

    public Integer getCodUsuariomarketing() {
        return codUsuariomarketing;
    }

    public void setCodUsuariomarketing(Integer codUsuariomarketing) {
        this.codUsuariomarketing = codUsuariomarketing;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codUsuariomarketing != null ? codUsuariomarketing.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuariomarketing)) {
            return false;
        }
        Usuariomarketing other = (Usuariomarketing) object;
        if ((this.codUsuariomarketing == null && other.codUsuariomarketing != null) || (this.codUsuariomarketing != null && !this.codUsuariomarketing.equals(other.codUsuariomarketing))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.data.entity.Usuariomarketing[ codUsuariomarketing=" + codUsuariomarketing + " ]";
    }
    
}
