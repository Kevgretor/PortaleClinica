package it.uniroma3.action;

import java.util.List;

import it.uniroma3.db.TipologiaEsame;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;

public class GetTipologiaEsame implements Action {

	public String perform(HttpServletRequest request) {
		
		//HelperProductId helper = new HelperProductId();
		
		//if (helper.isValid(request)) {
			Long id = Long.parseLong(request.getParameter("id"));
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica-unit");
			EntityManager em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
			@SuppressWarnings("unchecked")
			List<TipologiaEsame> list = em.createNamedQuery("getAllTipologiaEsame").getResultList();
			for (TipologiaEsame te : list)
			{

				if(te.getId()==id)
				{
					request.setAttribute("tesame", te);

					return "/dettagliTipologiaEsame.jsp";
				}
			}
			
		//} else
			return "/invalid.jsp";
	}
}
