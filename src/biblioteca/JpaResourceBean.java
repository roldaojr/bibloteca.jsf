package biblioteca;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
@ManagedBean
public class JpaResourceBean {
	protected EntityManagerFactory emf;

	public EntityManagerFactory getEMF() {
		if(emf == null) {
			emf = Persistence.createEntityManagerFactory("biblioteca");
		}
		return emf;
    }
}
