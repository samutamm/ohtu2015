
package com.mycompany.webkauppa;

import com.mycompany.webkauppa.sovelluslogiikka.Varasto;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LisaaOstoskoriinServlet extends WebKauppaServlet {

    public LisaaOstoskoriinServlet(Varasto v) {
        super(v);
    }

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        long tuoteId = Long.parseLong( request.getParameter("tuoteId") );
                        
//        OstoksenLisaysKoriin lisays = new OstoksenLisaysKoriin(haeSessionOstoskori(request), tuoteId);
//        lisays.suorita();
        komennot.ostoksenLisaysKoriin(haeSessionOstoskori(request), tuoteId, varasto).suorita();
        
        naytaSivu("/Tuotelista", request, response);   
    }
}
