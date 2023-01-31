package br.com.desafio.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import br.com.adesafio.modelo.MesAno;
import br.com.desafio.dao.MesAnoDAO;

public class MesAnoConverter implements Converter {
	


	public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {  
        if (submittedValue.trim().equals("")) {  
            return null;  
        } else {  
            try {  
                int number = Integer.parseInt(submittedValue);  
				MesAnoDAO dao = new MesAnoDAO();
                MesAno E = dao.getById(MesAno.class, number, "id");
               if(E==null)E = new MesAno();
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
        	 //System.out.println("converter>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+String.valueOf(((MesAno) value).getMesAno())); 
        	 String ret = String.valueOf(((MesAno) value).getId());  
        return ret;
        }  
    }  

}
