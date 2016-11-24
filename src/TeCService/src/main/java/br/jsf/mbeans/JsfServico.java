/*
    Requisito:              001
    Dono do Requisito:      Anderson Rodrigues
    Desenvolvedor:          Leonardo Santos Martins
 */
package br.jsf.mbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class JsfServico {
    
    private int cod_servico;
    private String descricao;
    private double valor;
    
    
    public JsfServico() {
    }

    public int getCod_servico() {
        return cod_servico;
    }

    public void setCod_servico(int cod_servico) {
        this.cod_servico = cod_servico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public void persist(){
       br.data.entity.Servico servico = new br.data.entity.Servico();
       servico.setCodServico(cod_servico);
       servico.setDescricao(descricao);
       servico.setValor((float) valor);
       new br.data.crud.CrudServico().persist(servico);
       this.cod_servico=0;
       this.descricao="";
       this.valor=0.00;
    }
    
    public void remove(br.data.entity.Servico servico){
        new br.data.crud.CrudServico().remove(servico);
    }
    
    public java.util.Collection<br.data.entity.Servico> getAll(){
        return new br.data.crud.CrudServico().getAll();
    }

    public String update(br.data.entity.Servico servico){
        this.cod_servico = servico.getCodServico();
        this.descricao = servico.getDescricao();
        this.valor = servico.getValor();
        return "merge.xhtml";
    }
    
    public void merge(){
        br.data.entity.Servico servico;
        servico = new br.data.crud.CrudServico().find(this.cod_servico);
        servico.setDescricao(this.descricao);
        servico.setValor((float) this.valor);
        new br.data.crud.CrudServico().merge(servico);
        this.cod_servico=0;
        this.descricao="";  
        this.valor=0.00;
    }
}