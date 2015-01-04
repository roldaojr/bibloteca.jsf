package biblioteca.controllers;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import biblioteca.dao.AutorDao;
import biblioteca.dominio.Autor;

@SessionScoped
@ManagedBean
public class AutorBean {
	@ManagedProperty(value="#{autorDao}")
	private AutorDao autorDao;

	private Autor autor;
	private DataModel<Autor> listaAutors;
	
	public Autor getAutor() {
		if(autor == null) {
			autor = new Autor();
		}
		return autor;
	}
	
	public DataModel<Autor> getAutors() {
		List<Autor> p = autorDao.findAll();
		listaAutors = new ListDataModel<>(p);
		return listaAutors;
	}
	
	public String adicionar() {
		autor = new Autor();
		return "form?faces-redirect=true";
	}
	
	public String atualizar() {
		autor = (Autor)(listaAutors.getRowData());
		return "form?faces-redirect=true";
	}
	
	public String salvar() {
		autorDao.update(autor);
		return "listar?faces-redirect=true";
	}

	public String confirmaApagar() {
		autor = (Autor)(listaAutors.getRowData());
		return "apagar?faces-redirect=true";
	}
	
	public String apagar() {
		autorDao.delete(autor);
		autor = null;
		return "listar?faces-redirect=true"; 
	}
	
	public AutorDao getAutorDao() {
		return autorDao;
	}

	public void setAutorDao(AutorDao autorDao) {
		this.autorDao = autorDao;
	}
}
