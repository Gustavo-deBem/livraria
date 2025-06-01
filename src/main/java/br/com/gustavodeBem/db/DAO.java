package br.com.gustavodeBem.db;

import java.util.List;

import br.com.gustavodeBem.entities.Livro;

public interface DAO {
	void save (Livro livro);
	void delete(Livro livro);
	void update(Livro livro);
	Livro getById(int id);
    List<Livro> getAll();

}
