package br.com.desafio.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import br.com.adesafio.modelo.Celula;
import br.com.desafio.dao.CelulaDAO;

public class CelulaConverter implements Converter {
	


	public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {  
        if (submittedValue.trim().equals("")) {  
            return null;  
        } else {  
            try {  
                int number = Integer.parseInt(submittedValue);  
				CelulaDAO dao = new CelulaDAO();
                Celula E = dao.getById(Celula.class, number, "id");
               if(E==null)E = new Celula();
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
        	 //System.out.println("converter>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+String.valueOf(((Celula) value).getCelula())); 
        	 String ret = String.valueOf(((Celula) value).getId());  
        return ret;
        }  
    }  

}
