package br.com.desafio.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.adesafio.modelo.Coordenacao;
import br.com.adesafio.modelo.Solicitacao;
import br.com.adesafio.modelo.Usuario;
import br.com.desafio.util.SessionFac;

public class SolicitacaoDAO extends DaoGenerico<Solicitacao, Integer> implements Serializable {
	
	
	

	public boolean saveAll(List<Solicitacao> sols){
		Session session = new SessionFac().getSession();
		session.beginTransaction();
		boolean ret =false;
		
		try
		{
			for(Solicitacao s: sols) {
			session.saveOrUpdate(s);
			}			
			ret=true;
			session.getTransaction().commit();
		}catch (Exception e) {
			ret=false;
			session.getTransaction().rollback();
			
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			session.close();
		}
		return ret;
		
		
	}
	

}
