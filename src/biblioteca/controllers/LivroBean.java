package biblioteca.controllers;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import biblioteca.dao.LivroDao;
import biblioteca.dominio.Livro;

@SessionScoped
@ManagedBean
public class LivroBean {
	@ManagedProperty(value="#{livroDao}")
	private LivroDao livroDao;

	private Livro livro;
	private DataModel<Livro> listaLivros;
	
	public Livro getLivro() {
		if(livro == null) {
			livro = new Livro();
		}
		return livro;
	}
	
	public DataModel<Livro> getLivros() {
		List<Livro> p = livroDao.findAll();
		listaLivros = new ListDataModel<>(p);
		return listaLivros;
	}
	
	public String adicionar() {
		livro = new Livro();
		return "form?faces-redirect=true";
	}
	
	public String atualizar() {
		livro = (Livro)(listaLivros.getRowData());
		return "form?faces-redirect=true";
	}
	
	public String salvar() {
		livroDao.update(livro);
		return "listar?faces-redirect=true";
	}

	public String confirmaApagar() {
		livro = (Livro)(listaLivros.getRowData());
		return "apagar?faces-redirect=true";
	}
	
	public String apagar() {
		livroDao.delete(livro);
		livro = null;
		return "listar?faces-redirect=true"; 
	}
	
	public LivroDao getLivroDao() {
		return livroDao;
	}

	public void setLivroDao(LivroDao livroDao) {
		this.livroDao = livroDao;
	}
}
