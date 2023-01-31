package br.com.desafio.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.adesafio.modelo.Usuario;
import br.com.desafio.dao.UsuarioDAO;

@ManagedBean(name="loginBeanPortal")
@SessionScoped
public class LoginPortalBean {

	

	private static final long serialVersionUID = 1L;
	public String sUsuario;
	public String sSenha;
	public Usuario user = new Usuario();
	private boolean displayRel, displaySol, displayMac;

	public String validaLogin(){
		 

		user = new UsuarioDAO().loginPortal(sUsuario, sSenha);  
		
		
		HttpSession sessions = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false); 
	    sessions.removeAttribute("uslogp");

		if(user!=null){

         montaMenu();  	
        
         sessions.setAttribute("uslogp", user );
           
           	return "/portal/relatorio?faces-redirect=true";	
       
           	
			
		}else	{
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Dados Incorretos","tente novamente"));
			return "";
		}
		
		
	}
		
	
	
	private void montaMenu() {
		
		if(user!=null) {
			
			switch (user.getPerfil()) {
			case "R":
				displayRel=true;
				displayMac=false;
				displaySol=false;
				break;
			case "M":
				displayRel=false;
				displayMac=true;
				displaySol=false;
				break;
			case "A":
				displayRel=true;
				displayMac=true;
				displaySol=true;
				break;
			default:
				break;
			}
			
			
		}
		
	}
	
	
	
	
	///////////////////////////////////////////////////// -Get´s e Set´s ////////////////////////////////////////////
	public String logout() { 
		System.out.println("saindo...");	
		 FacesContext facesContext = FacesContext.getCurrentInstance(); 
			HttpSession session = (HttpSession) facesContext .getExternalContext().getSession(false); 
			session.invalidate(); 
			return "/login?faces-redirect=true"; 
		}


	public String getsUsuario() {
		return sUsuario;
	}

	public void setsUsuario(String sUsuario) {
		this.sUsuario = sUsuario;
	}

	public String getsSenha() {
		return sSenha;
	}

	public void setsSenha(String sSenha) {
		this.sSenha = sSenha;
	}

	public Usuario getUser() {
		return user;
	}

	public boolean isDisplayRel() {
		return displayRel;
	}

	public boolean isDisplaySol() {
		return displaySol;
	}

	public boolean isDisplayMac() {
		return displayMac;
	}


	
	
}
