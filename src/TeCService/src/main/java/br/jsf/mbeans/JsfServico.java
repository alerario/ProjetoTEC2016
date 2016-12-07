/*
    Requisito:              001
    Dono do Requisito:      Anderson Rodrigues
    Desenvolvedor:          Leonardo Santos Martins
 */
package br.jsf.mbeans;

import br.data.entity.Agendamento;
import java.util.Collection;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class JsfServico {

    private Integer codServico;
    private String descricao;
    private float valor;
    private String propostaCliente;
    private String propostaFornecedor;
    private String intervaloCliente;
    private String intervaloFornecedor;
    private Boolean statusNegociacao;
    private Collection<Agendamento> agendamentoCollection;

    public JsfServico() {
    }

    public Integer getCodServico() {
        return codServico;
    }

    public void setCodServico(Integer codServico) {
        this.codServico = codServico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getPropostaCliente() {
        return propostaCliente;
    }

    public void setPropostaCliente(String propostaCliente) {
        this.propostaCliente = propostaCliente;
    }

    public String getPropostaFornecedor() {
        return propostaFornecedor;
    }

    public void setPropostaFornecedor(String propostaFornecedor) {
        this.propostaFornecedor = propostaFornecedor;
    }

    public String getIntervaloCliente() {
        return intervaloCliente;
    }

    public void setIntervaloCliente(String intervaloCliente) {
        this.intervaloCliente = intervaloCliente;
    }

    public String getIntervaloFornecedor() {
        return intervaloFornecedor;
    }

    public void setIntervaloFornecedor(String intervaloFornecedor) {
        this.intervaloFornecedor = intervaloFornecedor;
    }

    public Boolean getStatusNegociacao() {
        return statusNegociacao;
    }

    public void setStatusNegociacao(Boolean statusNegociacao) {
        this.statusNegociacao = statusNegociacao;
    }

    public Collection<Agendamento> getAgendamentoCollection() {
        return agendamentoCollection;
    }

    public void setAgendamentoCollection(Collection<Agendamento> agendamentoCollection) {
        this.agendamentoCollection = agendamentoCollection;
    }

    public void persist() {
        br.data.entity.Servico servico = new br.data.entity.Servico();
        servico.setCodServico(codServico);
        servico.setDescricao(descricao);
        servico.setValor(valor);
        servico.setPropostaCliente(propostaCliente);
        servico.setPropostaFornecedor(propostaFornecedor);
        servico.setIntervaloCliente(intervaloCliente);
        servico.setIntervaloFornecedor(intervaloFornecedor);
        servico.setStatusNegociacao(statusNegociacao);
        servico.setAgendamentoCollection(agendamentoCollection);
        new br.data.crud.CrudServico().persist(servico);

        this.codServico = 0;
        this.descricao = "";
        this.valor = 0;
        this.propostaCliente = "";
        this.propostaFornecedor = "";
        this.intervaloCliente = "";
        this.intervaloFornecedor = "";
        this.statusNegociacao = null;
        this.agendamentoCollection.removeAll(agendamentoCollection);
    }

    public void remove(br.data.entity.Servico servico) {
        new br.data.crud.CrudServico().remove(servico);
    }

    public java.util.Collection<br.data.entity.Servico> getAll() {
        return new br.data.crud.CrudServico().getAll();
    }

    public String update(br.data.entity.Servico servico) {
        this.codServico = servico.getCodServico();
        this.descricao = servico.getDescricao();
        this.valor = servico.getValor();
        this.propostaCliente = servico.getPropostaCliente();
        this.propostaFornecedor = servico.getPropostaFornecedor();
        this.intervaloCliente = servico.getIntervaloCliente();
        this.intervaloFornecedor = servico.getIntervaloFornecedor();
        this.statusNegociacao = servico.getStatusNegociacao();
        this.agendamentoCollection = servico.getAgendamentoCollection();
        return "merge.xhtml";
    }

    public void merge() {
        br.data.entity.Servico servico;
        
        servico = new br.data.crud.CrudServico().find(this.codServico);
        
        servico.setDescricao(descricao);
        servico.setValor(valor);
        servico.setPropostaCliente(propostaCliente);
        servico.setPropostaFornecedor(propostaFornecedor);
        servico.setIntervaloCliente(intervaloCliente);
        servico.setIntervaloFornecedor(intervaloFornecedor);
        servico.setStatusNegociacao(statusNegociacao);
        servico.setAgendamentoCollection(agendamentoCollection);
        
        new br.data.crud.CrudServico().merge(servico);

        this.codServico = 0;
        this.descricao = "";
        this.valor = 0;
        this.propostaCliente = "";
        this.propostaFornecedor = "";
        this.intervaloCliente = "";
        this.intervaloFornecedor = "";
        this.statusNegociacao = null;
        this.agendamentoCollection.removeAll(agendamentoCollection);
    }
}