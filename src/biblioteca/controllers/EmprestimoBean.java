package biblioteca.controllers;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import biblioteca.dao.EmprestimoDao;
import biblioteca.dominio.Emprestimo;

@SessionScoped
@ManagedBean
public class EmprestimoBean {
	@ManagedProperty(value="#{emprestimoDao}")
	private EmprestimoDao emprestimoDao;
	
	private Emprestimo emprestimo;
	private DataModel<Emprestimo> listaEmprestimos;
	
	public Emprestimo getEmprestimo() {
		if(emprestimo == null) {
			emprestimo = new Emprestimo();
		}
		return emprestimo;
	}
	
	public DataModel<Emprestimo> getEmprestimos() {
		List<Emprestimo> p = emprestimoDao.findAll();
		listaEmprestimos = new ListDataModel<>(p);
		return listaEmprestimos;
	}
	
	public String adicionar() {
		emprestimo = new Emprestimo();
		return "form?faces-redirect=true";
	}
	
	public String atualizar() {
		emprestimo = (Emprestimo)(listaEmprestimos.getRowData());
		return "form?faces-redirect=true";
	}
	
	public String salvar() {
		emprestimoDao.update(emprestimo);
		return "listar?faces-redirect=true";
	}

	public String confirmaApagar() {
		emprestimo = (Emprestimo)(listaEmprestimos.getRowData());
		return "apagar?faces-redirect=true";
	}
	
	public String apagar() {
		emprestimoDao.delete(emprestimo);
		emprestimo = null;
		return "listar?faces-redirect=true"; 
	}
	
	public EmprestimoDao getEmprestimoDao() {
		return emprestimoDao;
	}

	public void setEmprestimoDao(EmprestimoDao emprestimoDao) {
		this.emprestimoDao = emprestimoDao;
	}
}
