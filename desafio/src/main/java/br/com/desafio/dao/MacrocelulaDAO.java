package br.com.desafio.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.adesafio.modelo.Coordenacao;
import br.com.adesafio.modelo.Macrocelula;
import br.com.desafio.util.SessionFac;

public class MacrocelulaDAO extends DaoGenerico<Macrocelula, Integer> implements Serializable {
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public List<Macrocelula> findByCoordenacao (Coordenacao coord){
		
		
		Session session = new SessionFac().getSession();
		session.beginTransaction();
		Criteria crit = session.createCriteria(Macrocelula.class)
		.add(Restrictions.eq("coordenacao", coord));
		List<Macrocelula> macros = crit.list();
		session.getTransaction().commit();
		session.close();
		if(macros.size()>0){
			return macros;
			
		}else{
			return new ArrayList<Macrocelula>();
		}
					
				
}
	
	

}
