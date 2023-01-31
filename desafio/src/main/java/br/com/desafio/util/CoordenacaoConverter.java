package br.com.desafio.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import br.com.adesafio.modelo.Coordenacao;
import br.com.desafio.dao.CoordenacaoDAO;

public class CoordenacaoConverter implements Converter {
	


	public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {  
        if (submittedValue.trim().equals("")) {  
            return null;  
        } else {  
            try {  
                int number = Integer.parseInt(submittedValue);  
				CoordenacaoDAO dao = new CoordenacaoDAO();
                Coordenacao E = dao.getById(Coordenacao.class, number, "id");
               if(E==null)E = new Coordenacao();
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
        
        	 return "";  
        } else {  
        	 //System.out.println("converter>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+String.valueOf(((Coordenacao) value).getCoordenacao())); 
        	 String ret = String.valueOf(((Coordenacao) value).getId());  
        return ret;
        }  
    }  

}
