package br.com.desafio.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.adesafio.modelo.Usuario;
import br.com.desafio.util.SessionFac;

public class UsuarioDAO extends DaoGenerico<Usuario, Integer> implements Serializable {
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public Usuario login(String u, String s){
		
		
		Session session = new SessionFac().getSession();
		session.beginTransaction();
		Criteria crit = session.createCriteria(Usuario.class)
		.add(Restrictions.eq("usuario", u))
		.add(Restrictions.eq("senha", s));
		List<Usuario> OrdemCompras = crit.list();
		session.getTransaction().commit();
		session.close();
		if(OrdemCompras.size()>0){
			return OrdemCompras.get(0);
			
		}else{
			return null;
		}
					
				
}
	
	
	public Usuario loginPortal(String u, String s){
		
		
		Session session = new SessionFac().getSession();
		session.beginTransaction();
		Criteria crit = session.createCriteria(Usuario.class)
		.add(Restrictions.eq("usuario", u))
		.add(Restrictions.eq("senha", s));
		List<Usuario> OrdemCompras = crit.list();
		session.getTransaction().commit();
		session.close();
		if(OrdemCompras.size()>0){
			return OrdemCompras.get(0);
			
		}else{
			return null;
		}
					
				
}


public Usuario pesquisaUsuario(String u){
	
	
	Session session = new SessionFac().getSession();
	session.beginTransaction();
	Criteria crit = session.createCriteria(Usuario.class)
	.add(Restrictions.eq("usuario", u));
	List<Usuario> OrdemCompras = crit.list();
	session.getTransaction().commit();
	session.close();
	if(OrdemCompras.size()>0){
		return OrdemCompras.get(0);
		
	}else{
		return null;
	}
				
			
}


public boolean existe(String u){
	
	
	Session session = new SessionFac().getSession();
	session.beginTransaction();
	Criteria crit = session.createCriteria(Usuario.class)
	.add(Restrictions.eq("usuario", u));
	List<Usuario> OrdemCompras = crit.list();
	session.getTransaction().commit();
	session.close();
	if(OrdemCompras.size()>0){
		return true;
		
	}else{
		return false;
	}
				
			
}


	

}
