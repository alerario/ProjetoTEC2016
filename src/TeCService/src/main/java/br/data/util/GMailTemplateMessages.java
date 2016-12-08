/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.util;

import br.data.entity.Agendamento;
import br.data.entity.Servico;
import br.data.entity.Usuario;

/**
 *
 * @author ricardo
 */
public class GMailTemplateMessages {
    GMail gmail = new GMail();
    SendMail mail = new SendMail(gmail);
    
    public boolean alteracaoAgenda(Usuario u, Agendamento a){
        return mail.sendMessage("tecservice@gmail.com", u.getEmail(), "Ops! Alguém alterou a sua agenda!", 
                "Atenção "+u.getLogin() + " alguém alterou seu compromisso em "+ a.getDescricao());
    }
    
    public boolean alteracaoServico(Usuario u, Servico s){
        return mail.sendMessage("tecservice@gmail.com", u.getEmail(), "Ops! Alguém alterou seu serviço prestado!", 
                "Atenção "+u.getLogin() + " alguém alterou seu compromisso em "+ s.getDescricao());
    }
}
