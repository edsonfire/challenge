package br.com.desafio.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.adesafio.modelo.Atividade;
import br.com.adesafio.modelo.Celula;
import br.com.adesafio.modelo.Macrocelula;
import br.com.desafio.util.SessionFac;

public class AtividadeDAO extends DaoGenerico<Atividade, Integer> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<Atividade> findByCelula(Celula celula) {

		Session session = new SessionFac().getSession();
		session.beginTransaction();
		Criteria crit = session.createCriteria(Atividade.class).add(Restrictions.eq("celula", celula));
		List<Atividade> macros = crit.list();
		session.getTransaction().commit();
		session.close();
		if (macros.size() > 0) {
			return macros;

		} else {	
			return new ArrayList<Atividade>();
		}

	}

}
