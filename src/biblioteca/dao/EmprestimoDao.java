package biblioteca.dao;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;

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
}
