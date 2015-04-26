package com.mycompany.webkauppa;

import com.mycompany.webkauppa.ohjaus.OstoksenPoistoKorista;
import com.mycompany.webkauppa.sovelluslogiikka.Varasto;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PoistaOstoskoristaServlet extends WebKauppaServlet {

    public PoistaOstoskoristaServlet(Varasto v) {
        super(v);
    }
             
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        long tuoteId = Long.parseLong( request.getParameter("tuoteId") );
        
        //OstoksenPoistoKorista poisto = new OstoksenPoistoKorista(haeSessionOstoskori(request),  tuoteId );          
        //poisto.suorita();   
        komennot.ostoksenPoistoKorista(haeSessionOstoskori(request), tuoteId, varasto).suorita();
        
        naytaSivu("/MaksaOstokset", request, response);
    }
}
