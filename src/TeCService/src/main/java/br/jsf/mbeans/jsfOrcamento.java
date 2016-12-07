/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jsf.mbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Jéssica
 */
@ManagedBean
@RequestScoped
public class jsfOrcamento {
    
    private int codigo;
    private int codPrestador;
    private String descricao;
    
    public jsfOrcamento(){
        
    }
    
    public void enviar(){
       br.data.entity.Orcamento orc = new br.data.entity.Orcamento();
       orc.setCodOrcamento(codigo);
       //orc.setcodPrestador(codPrestador);
       orc.setDescricao(descricao);
       //new br.data.crud.CrudPrestador().enviar(codigo); Nao existe crud prestador
       this.setCodigo(0);
       this.setCodPrestador(0);
       this.descricao="";
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the codPrestador
     */
    public int getCodPrestador() {
        return codPrestador;
    }

    /**
     * @param codPrestador the codPrestador to set
     */
    public void setCodPrestador(int codPrestador) {
        this.codPrestador = codPrestador;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    /*
    public java.util.Collection<br.data.entity.Orcamento> getAll(){
        return new br.data.crud.CrudPrestador().getAll();
    }

    Comentario pois nao existe crudPrestador */
    
}
