/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jsf.mbeans;

import br.data.entity.Servico;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Aluno
 */
@ManagedBean
@RequestScoped
public class JsfAgenda {

    /**
     * Creates a new instance of JsfAgendamento
     */
    private Integer codAgendamento;
    private String dia;
    private String mes;
    private String ano;
    private String horas;
    private String minutos;
    private String duracao;
    private String descricao;
    private Servico codfkServico;

    public JsfAgenda() {}

    public void persist() {
        br.data.entity.Agenda agenda = new br.data.entity.Agenda();

        agenda.setAno(ano);
        agenda.setCodAgendamento(codAgendamento);
        agenda.setCodfkServico(codfkServico);
        agenda.setDescricao(descricao);
        agenda.setDia(dia);
        agenda.setHoras(horas);
        agenda.setMes(mes);
        agenda.setMinutos(minutos);

        new br.data.crud.CrudAgenda().persist(agenda);

        codAgendamento = 0;
        dia = "";
        mes = "";
        ano = "";
        horas = "";
        minutos = "";
        duracao = "";
        descricao = "";
        codfkServico = null;
    }

    public void remove(br.data.entity.Agenda agenda) {
        new br.data.crud.CrudAgenda().remove(agenda);
    }

    public java.util.Collection<br.data.entity.Agenda> getAll() {
        return new br.data.crud.CrudAgenda().getAll();
    }

    public String update(br.data.entity.Agenda agenda) {
        codAgendamento = agenda.getCodAgendamento();
        dia = agenda.getDia();
        mes = agenda.getMes();
        ano = agenda.getAno();
        horas = agenda.getHoras();
        minutos = agenda.getMinutos();
        duracao = agenda.getDuracao();
        descricao = agenda.getDescricao();
        codfkServico = agenda.getCodfkServico();
        
        return "merge.xhtml";
    }

    public void merge() {
        br.data.entity.Agenda agenda;

        agenda = new br.data.crud.CrudAgenda().find(this.codAgendamento);

        agenda.setAno(ano);
        agenda.setCodAgendamento(codAgendamento);
        agenda.setCodfkServico(codfkServico);
        agenda.setDescricao(descricao);
        agenda.setDia(dia);
        agenda.setHoras(horas);
        agenda.setMes(mes);
        agenda.setMinutos(minutos);

        new br.data.crud.CrudAgenda().merge(agenda);

        codAgendamento = 0;
        dia = "";
        mes = "";
        ano = "";
        horas = "";
        minutos = "";
        duracao = "";
        descricao = "";
        codfkServico = null;
    }

    public Integer getCodAgendamento() {
        return codAgendamento;
    }

    public void setCodAgendamento(Integer codAgendamento) {
        this.codAgendamento = codAgendamento;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getHoras() {
        return horas;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }

    public String getMinutos() {
        return minutos;
    }

    public void setMinutos(String minutos) {
        this.minutos = minutos;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Servico getCodfkServico() {
        return codfkServico;
    }

    public void setCodfkServico(Servico codfkServico) {
        this.codfkServico = codfkServico;
    }

    

}
