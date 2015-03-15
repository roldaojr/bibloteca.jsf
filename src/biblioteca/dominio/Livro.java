package biblioteca.dominio;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import biblioteca.BaseEntity;

@Entity
public class Livro extends BaseEntity {
	@Id
	@GeneratedValue
	private long id;
	private String titulo;
	private String codigoBarra;
	private int estante;
	private int exemplares;
	private int disponiveis;
	private int ano;
	private int volume;
	private int edicao;
	@ManyToOne(fetch=FetchType.LAZY)
	private Editora editora;
	@ManyToOne(fetch=FetchType.LAZY)
	private Autor autor;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id; 
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Editora getEditora() {
		return editora;
	}
	public void setEditora(Editora editora) {
		this.editora = editora;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	public String getCodigoBarra() {
		return codigoBarra;
	}
	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}
	public int getEstante() {
		return estante;
	}
	public void setEstante(int estante) {
		this.estante = estante;
	}
	public int getExemplares() {
		return exemplares;
	}
	public void setExemplares(int exemplares) {
		this.exemplares = exemplares;
	}
	public int getDisponiveis() {
		return disponiveis;
	}
	public void setDisponiveis(int disponiveis) {
		this.disponiveis = disponiveis;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public int getEdicao() {
		return edicao;
	}
	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}
}
