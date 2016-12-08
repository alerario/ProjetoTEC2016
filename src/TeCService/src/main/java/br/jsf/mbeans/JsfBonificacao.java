/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jsf.mbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.NamedQuery;

/**
 *
 * @author Valeria
 */
@ManagedBean
@RequestScoped
public class JsfBonificacao {
   
    public int quantidadeCompra;
    public int quantidadeBonificacao;
    
    public int buscaValores(int cliente, int servico){
        
        quantidadeCompra = 10;
        return quantidadeCompra;
        
    }
    
    public int valorBonificacao(){
        if (quantidadeCompra >= 10){
            return quantidadeBonificacao = 10;
        } else if (quantidadeCompra >= 20){
            return quantidadeBonificacao = 20;
        }else {
            return 0;
        }
        
    }
    
}
