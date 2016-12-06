/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jsf.mbeans;

import br.data.entity.Agenda;
import java.util.Collection;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class JsfCliente {

    private Integer idCliente;
    private String email;
    private String senha;
    private String nome;
  
    private Collection<Agenda> agendamentoCollection;

    public JsfCliente() {
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



  
    

    public void persist() {
        br.data.entity.Cliente cliente = new br.data.entity.Cliente();
        cliente.setIdCliente(idCliente);
        cliente.setEmail(email);
        cliente.setSenha(senha);
        cliente.setNome(nome);
        
        new br.data.crud.CrudCliente().persist(cliente);

        this.idCliente = 0;
        this.email = "";
        this.senha = "";
        this.nome = "";
      
        
    }

    public void remove(br.data.entity.Cliente cliente) {
        new br.data.crud.CrudCliente().remove(cliente);
    }

    public java.util.Collection<br.data.entity.Cliente> getAll() {
        return new br.data.crud.CrudCliente().getAll();
    }

    public String update(br.data.entity.Cliente cliente) {
        this.idCliente = cliente.getIdCliente();
        this.email = cliente.getEmail();
        this.senha = cliente.getSenha();
        this.nome = cliente.getNome();
       
        
        return "merge.xhtml";
    }

    public void merge() {
        br.data.entity.Cliente cliente;
        
        cliente = new br.data.crud.CrudCliente().find(this.idCliente);
        
        cliente.setEmail(email);
        cliente.setSenha(senha);
        cliente.setNome(nome);
        
        
        new br.data.crud.CrudCliente().merge(cliente);

        this.idCliente = 0;
        this.email = "";
        this.senha = "";
        this.nome = "";
        
        
    }
}
