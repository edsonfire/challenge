package br.com.desafio.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.adesafio.modelo.Celula;
import br.com.adesafio.modelo.Macrocelula;
import br.com.desafio.util.SessionFac;

public class CelulaDAO extends DaoGenerico<Celula, Integer> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<Celula> findByMacroCelula(Macrocelula macro) {

		Session session = new SessionFac().getSession();
		session.beginTransaction();
		Criteria crit = session.createCriteria(Celula.class).add(Restrictions.eq("macrocelula", macro));
		List<Celula> macros = crit.list();
		session.getTransaction().commit();
		session.close();
		if (macros.size() > 0) {
			return macros;

		} else {	
			return new ArrayList<Celula>();
		}

	}

}
