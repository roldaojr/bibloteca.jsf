package biblioteca.dao;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import biblioteca.dominio.Editora;

@ApplicationScoped
@ManagedBean(name="editoraDao")
public class EditoraDao extends GenericDao<Editora> {
	public EditoraDao() {
		super(Editora.class);
	}
}
