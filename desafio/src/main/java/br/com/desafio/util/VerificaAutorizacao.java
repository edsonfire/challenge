package br.com.desafio.util;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.adesafio.modelo.Usuario;

public class VerificaAutorizacao {
	
	
	private Usuario usuarioLogado;
	
	
	public VerificaAutorizacao(){
	HttpSession sessions = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);   
    usuarioLogado = (Usuario)sessions.getAttribute("uslogp");
   
    
	}
	
	
	
	public boolean possuidireitosdeMaster(){
		if(usuarioLogado.getPerfil().equals("M")){
			
				return true;
			}else{
			
				return false;
			}
		
		
	}
	
	
	public boolean possuidireitosdeRelatorio(){
		if(usuarioLogado.getPerfil().equals("R")){
			
				return true;
			}else{
			
				return false;
			}
		
		
	}
	


	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}


}
