/*
    Requisito:              001
    Dono do Requisito:      Anderson Rodrigues
    Desenvolvedor:          Leonardo Santos Martins
 */
package br.data.crud;

import br.data.entity.Servico;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;


public class CrudServico extends AbstractCrud<Servico> {

    private EntityManager em;

    private static final String PU = EMNames.EMN1;

    public CrudServico() {
        super(Servico.class);
    }

    /*
    public List<br.data.entity.Servico> SelectByNome(String nome) {
        try {
            return getEntityManager().createNamedQuery("Teste.findByNome").setParameter("nome", "%" + nome.toUpperCase() + "%").getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    */

    @Override
    protected EntityManager getEntityManager() {
        if (em == null) {
            em = Persistence.createEntityManagerFactory(PU).createEntityManager();
        }
        return em;
    }

}