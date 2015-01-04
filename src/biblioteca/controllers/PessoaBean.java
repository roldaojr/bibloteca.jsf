package biblioteca.controllers;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import biblioteca.dao.PessoaDao;
import biblioteca.dominio.Pessoa;

@SessionScoped
@ManagedBean
public class PessoaBean {
	@ManagedProperty(value="#{pessoaDao}")
	private PessoaDao pessoaDao;

	private Pessoa pessoa;
	private DataModel<Pessoa> listaPessoas;
	
	public Pessoa getPessoa() {
		if(pessoa == null) {
			pessoa = new Pessoa();
		}
		return pessoa;
	}
	
	public DataModel<Pessoa> getPessoas() {
		List<Pessoa> p = pessoaDao.findAll();
		listaPessoas = new ListDataModel<>(p);
		return listaPessoas;
	}
	
	public String adicionar() {
		pessoa = new Pessoa();
		return "form?faces-redirect=true";
	}
	
	public String atualizar() {
		pessoa = (Pessoa)(listaPessoas.getRowData());
		return "form?faces-redirect=true";
	}
	
	public String salvar() {
		pessoaDao.update(pessoa);
		return "listar?faces-redirect=true";
	}

	public String confirmaApagar() {
		pessoa = (Pessoa)(listaPessoas.getRowData());
		return "apagar?faces-redirect=true";
	}
	
	public String apagar() {
		pessoaDao.delete(pessoa);
		pessoa = null;
		return "listar?faces-redirect=true"; 
	}
	
	public PessoaDao getPessoaDao() {
		return pessoaDao;
	}

	public void setPessoaDao(PessoaDao pessoaDao) {
		this.pessoaDao = pessoaDao;
	}
}
