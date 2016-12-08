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
 * @author Rafael
 */
@ManagedBean
@RequestScoped
public class jsfSiteEmpresa {
    
    public jsfSiteEmpresa(){
        
    }
    
    private int codServico;
    private int codPrestador;
    private int valor;

    
    public void persist(){
       br.data.entity.siteEmpresa se = new br.data.entity.siteEmpresa();
       se.setCodServico(codServico);
       se.setCodPrestador(codPrestador);
       se.setValor(valor);
       this.codServico=0;
       this.codPrestador=0;
       this.valor=0;
    }
    
    /**
     * @return the codServico
     */
    public int getCodServico() {
        return codServico;
    }

    /**
     * @param codServico the codServico to set
     */
    public void setCodServico(int codServico) {
        this.codServico = codServico;
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
     * @return the valor
     */
    public int getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(int valor) {
        this.valor = valor;
    }
    
    
}
