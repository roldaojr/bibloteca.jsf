package biblioteca.controllers;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import biblioteca.dao.EditoraDao;
import biblioteca.dominio.Editora;

@SessionScoped
@ManagedBean
public class EditoraBean {
	@ManagedProperty(value="#{editoraDao}")
	private EditoraDao editoraDao;

	private Editora editora;
	private DataModel<Editora> listaEditoras;
	
	public Editora getEditora() {
		if(editora == null) {
			editora = new Editora();
		}
		return editora;
	}
	
	public DataModel<Editora> getEditoras() {
		List<Editora> p = editoraDao.findAll();
		listaEditoras = new ListDataModel<>(p);
		return listaEditoras;
	}

	public String adicionar() {
		editora = new Editora();
		return "form?faces-redirect=true";
	}
	
	public String atualizar() {
		editora = (Editora)(listaEditoras.getRowData());
		return "form?faces-redirect=true";
	}
	
	public String salvar() {
		editoraDao.update(editora);
		return "listar?faces-redirect=true";
	}

	public String confirmaApagar() {
		editora = (Editora)(listaEditoras.getRowData());
		return "apagar?faces-redirect=true";
	}
	
	public String apagar() {
		editoraDao.delete(editora);
		editora = null;
		return "listar?faces-redirect=true"; 
	}
	
	public EditoraDao getEditoraDao() {
		return editoraDao;
	}

	public void setEditoraDao(EditoraDao editoraDao) {
		this.editoraDao = editoraDao;
	}
}
