package br.com.gustavodeBem.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import br.com.gustavodeBem.conn.ConectionFactory;
import br.com.gustavodeBem.db.DAO;
import br.com.gustavodeBem.entities.Livro;


public class LivroService implements DAO{
	
	

	@Override
	public void save(Livro livro) {

		
		String sql = "INSERT INTO LIVRO (NOME,AUTOR,DATAPUBLICACAO,EDITORA,GENERO,SINOPSE) VALUES(?,?,?,?,?,?)";
		
		PreparedStatement ps = null;
		
		try(Connection conn = ConectionFactory.getConection()) {
			
			LocalDate localDate = LocalDate.parse(livro.getDataPublicacao());
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, livro.getNome());
			ps.setString(2, livro.getAutor());
			ps.setDate(3, java.sql.Date.valueOf(localDate));
			ps.setString(4, livro.getEditora());
			ps.setString(5, livro.getGenero());
			ps.setString(6, livro.getSinopse());
			
			ps.executeUpdate();
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

		
	

	@Override
	public void delete(Livro livro) {
		
		if (livro== null || livro.getId() == null) {
			System.out.println("Não foi possivel achar o livro");
			return;
		}
		try(Connection conn = ConectionFactory.getConection()){
			
			String sql = "DELETE FROM LIVRO WHERE ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, livro.getId());
			ps.executeUpdate();		
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Livro livro) {
		if (livro== null || livro.getId() == null) {
			System.out.println("Não foi possivel achar o livro");
			return;
		}
		String sql = "UPDATE LIVRO SET nome = ?,nome = ?, dataPublicacao = ?, editora = ?, genero = ?,  sinopse = ? WHERE id = ? ";
			
		try(Connection conn = ConectionFactory.getConection()){
		   LocalDate localDate = LocalDate.parse(livro.getDataPublicacao());	
           PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, livro.getNome());
			ps.setString(2, livro.getAutor());
			ps.setDate(3, java.sql.Date.valueOf(localDate));
			ps.setString(4, livro.getEditora());
			ps.setString(5, livro.getGenero());
			ps.setString(6, livro.getSinopse());
			ps.setInt(7, livro.getId());
			
			
			ps.executeUpdate();
			System.out.println("Livro atualizado com sucesso");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Livro getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Livro> getAll() {
		
	
		    List<Livro> livros = new ArrayList<>();

		    String sql = "SELECT * FROM livro";

		    try (Connection conn = ConectionFactory.getConection();
		         PreparedStatement stmt = conn.prepareStatement(sql);
		         ResultSet rs = stmt.executeQuery()) {

		        while (rs.next()) {
		            Livro livro = new Livro();
		            livro.setId(rs.getInt("id"));
		            livro.setNome(rs.getString("nome"));
		            livro.setAutor(rs.getString("autor"));
		            livro.setDataPublicacao(rs.getString("dataPublicacao"));
		            livro.setEditora(rs.getString("editora"));
		            livro.setSinopse(rs.getString("sinopse"));
		            livro.setGenero(rs.getString("genero"));
		            livros.add(livro);
		        }

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return livros;
		}

		
		
		
	
	
	

}
