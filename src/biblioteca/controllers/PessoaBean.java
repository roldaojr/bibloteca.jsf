package biblioteca.controllers;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import biblioteca.dao.PessoaDao;
import biblioteca.dominio.*;

@SessionScoped
@ManagedBean
public class PessoaBean {
	@ManagedProperty(value="#{pessoaDao}")
	private PessoaDao pessoaDao;

	private Pessoa novaPessoa;
	
	public Pessoa getNovaPessoa() {
		if(novaPessoa == null) {
			novaPessoa = new Pessoa();
		}
		return novaPessoa;
	}
	
	public List<Pessoa> getPessoas() {
		return pessoaDao.findAll();
	}
	
	public void adicionar() {
		pessoaDao.create(novaPessoa);
		novaPessoa = null;
	}

	public PessoaDao getPessoaDao() {
		return pessoaDao;
	}

	public void setPessoaDao(PessoaDao pessoaDao) {
		this.pessoaDao = pessoaDao;
	}
}
