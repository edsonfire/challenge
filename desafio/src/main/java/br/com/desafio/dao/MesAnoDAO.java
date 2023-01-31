package br.com.desafio.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.adesafio.modelo.Celula;
import br.com.adesafio.modelo.Macrocelula;
import br.com.adesafio.modelo.MesAno;
import br.com.desafio.util.SessionFac;

public class MesAnoDAO extends DaoGenerico<MesAno, Integer> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<MesAno> findOrder() {

		Session session = new SessionFac().getSession();
		session.beginTransaction();
		Criteria crit = session.createCriteria(MesAno.class).addOrder(Order.asc("mes")).addOrder(Order.asc("ano"));

		List<MesAno> mas = crit.list();
		session.getTransaction().commit();
		session.close();
		if (mas.size() > 0) {
			return mas;

		} else {
			return new ArrayList<MesAno>();
		}

	}

}
