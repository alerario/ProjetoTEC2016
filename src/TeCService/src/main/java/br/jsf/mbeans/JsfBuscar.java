//Aluno: Augusto Henrique Salla Rosa
//RA: 1476852
//Faltou implementarem: Busca por tipo no CrudServico, CrudEmpresa
package br.jsf.mbeans;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import br.data.crud.CrudServico;

@ManagedBean
@RequestScoped
public class JsfBuscar {
    
    private String Tipo;
    private String Nome;
    private java.util.Collection<br.data.entity.Servico> ListaDeServicos;
    private final CrudServico CrudSvc;
    
    public JsfBuscar(){
        CrudSvc = new CrudServico();
    }
    
    public int tipoBusca(String ti) {
        switch(ti) {
            case "Empresa":
                return 1;
            case "Servico":
                return 2;
            default:
                return 0;
        }
    }
    
    public String realizarBusca() {
        switch (this.tipoBusca(this.getTipo())) {
            case 1: {
                this.ListaDeServicos = null;
                return "index.xhtml";                
            }
            case 2: {
                this.ListaDeServicos = this.CrudSvc.getAll();
                return "index.xhtml";                
            }
            default: {
                this.ListaDeServicos = null;
                return "index.xhtml";
            }
        }
    }
    public String getNome() {
        return this.Nome;
    }
    public void setNome(String n) {
        this.Nome = n;
    }
    public String getTipo() {
        return this.Tipo;
    }
    public void setTipo(String t) {
        this.Tipo = t;
    }
    public java.util.Collection<br.data.entity.Servico> getListaServicos() {
        return this.ListaDeServicos;
    }
}
