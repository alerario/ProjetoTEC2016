package br.jsf.mbeans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Lucas
 */
@ManagedBean(name = "calendario")
@SessionScoped
public class ExportarEvento {
    
    private String template;    
    
    String caminho = "C:\\";
    //nome do evento
    private String evento = "Pintar predio";
    //descrição do evento
    private String descricao = "Pintar a parte externa da predio.";
        
    //colocar os valores correspondentes
    private int 
    diaInicio = 10,
    diaTermino = 11,
    mesInicio = 11,
    mesTermino = 11,
    anoInicio = 2016,
    anoTermino = 2016,
            
    //colocar horário de início
    hora = 17,
    minuto = 30;

    public void criarCsv() {

        template
                = "BEGIN:VCALENDAR\n"
                + "PRODID:-//Google Inc//Google Calendar 70.9054//EN\n"
                + "VERSION:2.0\n"
                + "CALSCALE:GREGORIAN\n"
                + "METHOD:PUBLISH\n"
                + "X-WR-TIMEZONE:America/Sao_Paulo\n"
                + "BEGIN:VEVENT\n"
                + "DTSTART;VALUE=DATE:" + anoInicio + mesInicio + diaInicio + "\n"
                + "DTEND;VALUE=DATE:" + anoTermino + mesTermino + diaTermino + "\n"
                + "DTSTAMP:" + anoInicio + mesInicio + diaInicio + "T" + hora + minuto + "00Z\n"
                + "CLASS:PUBLIC\n"
                + "DESCRIPTION: "+ descricao +"\n"
                + "SEQUENCE:0\n"
                + "STATUS:CONFIRMED\n"
                + "SUMMARY: "+ evento +"\n"
                + "TRANSP:OPAQUE\n"
                + "END:VEVENT\n"
                + "END:VCALENDAR";

        FileWriter arquivo;

        try {
            arquivo = new FileWriter(new File(caminho + "Evento " + evento + ".ics"));
            arquivo.write(template);
            arquivo.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
