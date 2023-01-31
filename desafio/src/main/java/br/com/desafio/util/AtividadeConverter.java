package br.com.desafio.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import br.com.adesafio.modelo.Atividade;
import br.com.desafio.dao.AtividadeDAO;

public class AtividadeConverter implements Converter {
	


	public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {  
        if (submittedValue.trim().equals("")) {  
            return null;  
        } else {  
            try {  
                int number = Integer.parseInt(submittedValue);  
				AtividadeDAO dao = new AtividadeDAO();
                Atividade E = dao.getById(Atividade.class, number, "id");
               if(E==null)E = new Atividade();
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
        	 //System.out.println("converter>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+String.valueOf(((Atividade) value).getAtividade())); 
        	 String ret = String.valueOf(((Atividade) value).getId());  
        return ret;
        }  
    }  

}
