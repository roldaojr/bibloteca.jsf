package biblioteca.dao;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import biblioteca.dominio.Autor;

@ApplicationScoped
@ManagedBean(name="autorDao")
public class AutorDao extends GenericDao<Autor> {
	public AutorDao() {
		super(Autor.class);
	}
}
