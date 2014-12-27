package biblioteca.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import biblioteca.JpaResourceBean;
import biblioteca.dominio.Pessoa;

@ApplicationScoped
@ManagedBean(name="pessoaDao")
public class PessoaDao {
	@ManagedProperty(value="#{jpaResourceBean}")
    private JpaResourceBean jpa;
	
	public void create(Pessoa pessoa) {
		EntityManager em = jpa.getEMF().createEntityManager();
		em.getTransaction().begin();
		em.persist(pessoa);
		em.getTransaction().commit();
		em.close();
	}

	public List<Pessoa> findAll() {
		EntityManager em = jpa.getEMF().createEntityManager();
		try{
			Query query = em.createQuery("select e from Pessoa e");
			return query.getResultList();			
		} finally {
			em.close();
		}
	}

	public Pessoa findByCPF(long cpf) {
		return null;
	}

	public JpaResourceBean getJpa() {
		return jpa;
	}

	public void setJpa(JpaResourceBean jpa) {
		this.jpa = jpa;
	}

}
