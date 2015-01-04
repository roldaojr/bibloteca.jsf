package biblioteca.dao;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import biblioteca.dominio.Emprestimo;

@ApplicationScoped
@ManagedBean(name="emprestimoDao")
public class EmprestimoDao extends GenericDao<Emprestimo> {
	public EmprestimoDao() {
		super(Emprestimo.class);
	}
}
