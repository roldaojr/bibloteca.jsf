package biblioteca.dao;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import biblioteca.dominio.Livro;

@ApplicationScoped
@ManagedBean(name="livroDao")
public class LivroDao extends GenericDao<Livro> {
	public LivroDao() {
		super(Livro.class);
	}
}
