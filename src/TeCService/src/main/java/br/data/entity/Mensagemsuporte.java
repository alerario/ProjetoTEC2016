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
@Table(name = "mensagemsuporte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mensagemsuporte.findAll", query = "SELECT m FROM Mensagemsuporte m")
    , @NamedQuery(name = "Mensagemsuporte.findByCodMensagem", query = "SELECT m FROM Mensagemsuporte m WHERE m.codMensagem = :codMensagem")
    , @NamedQuery(name = "Mensagemsuporte.findByAssuntoMensagem", query = "SELECT m FROM Mensagemsuporte m WHERE m.assuntoMensagem = :assuntoMensagem")
    , @NamedQuery(name = "Mensagemsuporte.findByRespostaMensagem", query = "SELECT m FROM Mensagemsuporte m WHERE m.respostaMensagem = :respostaMensagem")
    , @NamedQuery(name = "Mensagemsuporte.findByPerguntaMensagem", query = "SELECT m FROM Mensagemsuporte m WHERE m.perguntaMensagem = :perguntaMensagem")})
public class Mensagemsuporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_mensagem")
    private Integer codMensagem;
    @Size(max = 100)
    @Column(name = "assunto_mensagem")
    private String assuntoMensagem;
    @Size(max = 1000)
    @Column(name = "resposta_mensagem")
    private String respostaMensagem;
    @Size(max = 1000)
    @Column(name = "pergunta_mensagem")
    private String perguntaMensagem;
    @JoinColumn(name = "cod_cliente", referencedColumnName = "cod_cliente")
    @ManyToOne
    private Cliente codCliente;
    @JoinColumn(name = "cod_prestador", referencedColumnName = "cod_prestador")
    @ManyToOne
    private Prestador codPrestador;

    public Mensagemsuporte() {
    }

    public Mensagemsuporte(Integer codMensagem) {
        this.codMensagem = codMensagem;
    }

    public Integer getCodMensagem() {
        return codMensagem;
    }

    public void setCodMensagem(Integer codMensagem) {
        this.codMensagem = codMensagem;
    }

    public String getAssuntoMensagem() {
        return assuntoMensagem;
    }

    public void setAssuntoMensagem(String assuntoMensagem) {
        this.assuntoMensagem = assuntoMensagem;
    }

    public String getRespostaMensagem() {
        return respostaMensagem;
    }

    public void setRespostaMensagem(String respostaMensagem) {
        this.respostaMensagem = respostaMensagem;
    }

    public String getPerguntaMensagem() {
        return perguntaMensagem;
    }

    public void setPerguntaMensagem(String perguntaMensagem) {
        this.perguntaMensagem = perguntaMensagem;
    }

    public Cliente getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Cliente codCliente) {
        this.codCliente = codCliente;
    }

    public Prestador getCodPrestador() {
        return codPrestador;
    }

    public void setCodPrestador(Prestador codPrestador) {
        this.codPrestador = codPrestador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMensagem != null ? codMensagem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mensagemsuporte)) {
            return false;
        }
        Mensagemsuporte other = (Mensagemsuporte) object;
        if ((this.codMensagem == null && other.codMensagem != null) || (this.codMensagem != null && !this.codMensagem.equals(other.codMensagem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.data.entity.Mensagemsuporte[ codMensagem=" + codMensagem + " ]";
    }
    
}
