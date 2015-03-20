package biblioteca.dao;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import biblioteca.JpaResourceBean;
import biblioteca.dominio.Emprestimo;

@ApplicationScoped
@ManagedBean(name="emprestimoDao")
public class EmprestimoDao extends GenericDao<Emprestimo> {
	public EmprestimoDao() {
		super(Emprestimo.class);
	}
	public void create(Emprestimo t) {
		EntityManager em = jpa.getEMF().createEntityManager();
		em.getTransaction().begin();
		int disponiveis = t.getLivro().getDisponiveis();
		t.getLivro().setDisponiveis(disponiveis - 1);
		em.persist(t);
		em.getTransaction().commit();
		em.close();
	}
	@SuppressWarnings("unchecked")
	public List<Emprestimo> atrasados() {
		if (jpa == null) {
			jpa = new JpaResourceBean();
		}
		EntityManager em = jpa.getEMF().createEntityManager();
		Query query = em.createQuery("from Emprestimo e where e.dataDevolucao < ?")
				.setParameter(1, new Date());
		try{
			return query.getResultList();
		} finally {
			em.close();
		}
	}
}
