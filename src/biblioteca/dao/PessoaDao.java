package biblioteca.dao;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import biblioteca.dominio.Pessoa;

@ApplicationScoped
@ManagedBean(name="pessoaDao")
public class PessoaDao extends GenericDao<Pessoa> {
	public PessoaDao() {
		super(Pessoa.class);
	}
}
