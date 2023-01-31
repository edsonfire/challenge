package br.com.desafio.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import br.com.adesafio.modelo.Usuario;
import br.com.desafio.dao.UsuarioDAO;

public class UsuarioConverter implements Converter {
	


	public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {  
        if (submittedValue.trim().equals("")) {  
            return null;  
        } else {  
            try {  
                int number = Integer.parseInt(submittedValue);  
                UsuarioDAO dao = new UsuarioDAO();
                Usuario E = dao.getById(Usuario.class, number, "id");
               if(E==null)E = new Usuario();
               //System.out.println("converter>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+E.getId());
               return E;
            } catch(NumberFormatException exception) {  
                //System.out.println("pequena falha"); 
                return null;
            }  
        }  
  
       
    }  
  
    public String getAsString(FacesContext facesContext, UIComponent component, Object value) {  
        if (value == null || value.equals("")) {  
        	
        	 //System.out.println("falha ao converter o usuario");
        	 return "";  
        } else {  
        	 //System.out.println("converter>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+String.valueOf(((Usuario) value).getUsuario())); 
        	 String ret = String.valueOf(((Usuario) value).getId());  
        return ret;
        }  
    }  

}
