package br.com.desafio.util;

import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.servlet.http.HttpSession;

public class LogoutListener implements ActionListener {
    @Override
    public void processAction(ActionEvent event)
            throws AbortProcessingException {
    	System.out.println(" matando a sessão e saindo...");	
		 FacesContext facesContext = FacesContext.getCurrentInstance(); 
			HttpSession session = (HttpSession) facesContext .getExternalContext().getSession(false); 
			session.invalidate(); 
			
    }
}