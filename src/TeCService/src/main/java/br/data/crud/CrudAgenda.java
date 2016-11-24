/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.crud;

import br.data.entity.Agenda;
import br.data.entity.Teste;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class CrudAgenda extends AbstractCrud<Agenda> {
    
    private EntityManager em;
    private static final String PU = EMNames.EMN1;

    public CrudAgenda() {
        super(Agenda.class);
    }
    
    
    /* Métodos do implements */
    @Override
    protected EntityManager getEntityManager() {
        if (em == null) {
            em = Persistence.createEntityManagerFactory(PU).createEntityManager();
        }
        return em;
    }
    
}
