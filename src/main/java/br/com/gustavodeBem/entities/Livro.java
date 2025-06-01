package br.com.gustavodeBem.entities;

import java.sql.Date;

public class Livro {
	
	private Integer id;
	@Override
	public String toString() {
		return "Livro [id=" + id + ", autor=" + autor + ", nome=" + nome + ", editora=" + editora + ", genero=" + genero
				+ ", sinopse=" + sinopse + ", dataPublicacao=" + dataPublicacao + "]";
	}

	private String autor;
	private String nome;
	private String editora;
	private String genero;
	private String sinopse;
	private String dataPublicacao;
	
	public Livro() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(String dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Livro(int id, String autor, String nome, String editora, String genero, String sinopse,
			String dataPublicacao) {
		super();
		this.id = id;
		this.autor = autor;
		this.nome = nome;
		this.editora = editora;
		this.genero = genero;
		this.sinopse = sinopse;
		this.dataPublicacao = dataPublicacao;
	}
	
	
	
}