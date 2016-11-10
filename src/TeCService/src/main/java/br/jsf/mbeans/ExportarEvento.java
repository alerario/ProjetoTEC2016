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
import java.io.OutputStream;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

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
    
    public void download() throws IOException {
    FacesContext fc = FacesContext.getCurrentInstance();
    ExternalContext ec = fc.getExternalContext();

    ec.responseReset(); // Some JSF component library or some Filter might have set some headers in the buffer beforehand. We want to get rid of them, else it may collide.
    ec.setResponseContentType("text/calendar"); 
// Check http://www.iana.org/assignments/media-types for all types.
 //Use if necessary ExternalContext#getMimeType() for auto-detection based on filename.
//    ec.setResponseContentLength(contentLength); 
// Set it with the file size. This header is optional. It will work if it's omitted, but the download progress will be unknown.
    ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + evento + "\""); // The Save As popup magic is done here. You can give it any file name you want, this only won't work in MSIE, it will use current request URL as file name instead.

    OutputStream output = ec.getResponseOutputStream();
    // Now you can write the InputStream of the file to the above 
    //OutputStream the usual way.
    // ...
    criarCsv();
   output.write(template.getBytes());
    output.flush();
    output.close();
    fc.responseComplete(); // Important! Otherwise JSF will attempt to render the response which obviously will fail since it's already written with a file and closed.
}
    
}
