package biblioteca.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import biblioteca.JpaResourceBean;

@ApplicationScoped
public class GenericDao<T> {
	@ManagedProperty(value="#{jpaResourceBean}")
    protected JpaResourceBean jpa;
	
	protected Class<T> type;
	
	public GenericDao(Class<T> type) {
		this.type = type;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public GenericDao() {
		this.type = ((Class) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0]);
	}
	
	public void create(T t) {
		EntityManager em = jpa.getEMF().createEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
	}

	public void update(T t) {
		EntityManager em = jpa.getEMF().createEntityManager();
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
		em.close();		
	}

	public void delete(T t) {
		EntityManager em = jpa.getEMF().createEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(t));
		em.getTransaction().commit();
		em.close();		
	}
	
	public List<T> findAll() {
		EntityManager em = jpa.getEMF().createEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		try{
			CriteriaQuery<T> c = cb.createQuery(type);
			c.from(type);
			TypedQuery<T> query = em.createQuery(c);
			return query.getResultList();
		} finally {
			em.close();
		}
	}
	
	public T find(long id) {
		EntityManager em = jpa.getEMF().createEntityManager();
		return em.find(type, id);
	}

	public JpaResourceBean getJpa() {
		return jpa;
	}

	public void setJpa(JpaResourceBean jpa) {
		this.jpa = jpa;
	}
}
