package model;

//import java.rmi.server.SocketSecurityException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MusicDao {
	
	//agendarSessao = cadastro
	public void cadastra(Music usuariomusic) {
		Connection con = Conexao.obterConexao();
		
		String sql = "INSERT INTO Music(nomeEstudio, nomeCliente, numMusicasGravadas, taxaHoraEstudio, faturamento, agendarSessao, mixarMusica, valorTotal) "
				+ "VALUES(?,?,?,?,?,?,?,?)";

		try {
			
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usuariomusic.getNomeEstudio());
			preparador.setString(2, usuariomusic.getNomeCliente());
			preparador.setDouble(3, usuariomusic.getNumMusicasGravadas());
			preparador.setDouble(4, usuariomusic.getTaxaHoraEstudio());
			preparador.setDouble(5, usuariomusic.getFaturamento());
			preparador.setString(6, usuariomusic.getAgendarSessao());
			preparador.setDouble(7, usuariomusic.getMixarMusica());
			preparador.setDouble(8, usuariomusic.getValorTotal());
			preparador.execute();
			preparador.close();
			System.out.println("CLIENTE CADASTRADO COM SUCESSO!");
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public List<Music> mostraTodos() {
		Connection con = Conexao.obterConexao();
		List<Music> musicas = new ArrayList<> ();
		
		String sql = "SELECT * FROM Music";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet resultado = preparador.executeQuery();
			
			while(resultado.next()) {
				
				Music usuariomusic = new Music();
				usuariomusic.setIdCliente(resultado.getInt("idCliente"));
				usuariomusic.setNomeEstudio(resultado.getString("nomeEstudio"));
				usuariomusic.setNomeCliente(resultado.getString("nomeCliente")); 
				usuariomusic.setNumMusicasGravadas(resultado.getDouble("numMusicasGravadas"));
				usuariomusic.setTaxaHoraEstudio(resultado.getDouble("taxaHoraEstudio"));
				usuariomusic.setFaturamento(resultado.getDouble("faturamento"));
				usuariomusic.setAgendarSessao(resultado.getString("agendarSessao"));
				usuariomusic.setMixarMusica(resultado.getDouble("mixarMusica"));
				usuariomusic.setValorTotal(resultado.getDouble("valorTotal"));
				musicas.add(usuariomusic);
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return musicas;
	}
	
	public Music mostraPorIdCliente(int idCliente) {
		Connection con = Conexao.obterConexao();
		
		Music musicas = null;
		String sql = "SELECT * FROM Music WHERE idCliente=?"; //
		
		try {
			
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1,idCliente);
			ResultSet resultado = preparador.executeQuery();
			
			if(resultado.next()) {
				musicas = new Music();
				
				//ver se realmente preciso colocar o nome do cliente aqui, ou se preciso criar um id do cliente como se fosse o ra dele
				//(no caso nao muda)
				musicas.setIdCliente(resultado.getInt("idCliente"));
				musicas.setNomeEstudio(resultado.getString("nomeEstudio"));
				musicas.setNomeCliente(resultado.getString("nomeCliente"));
				musicas.setNumMusicasGravadas(resultado.getDouble("numMusicasGravadas"));
				musicas.setTaxaHoraEstudio(resultado.getDouble("taxaHoraEstudio"));
				musicas.setFaturamento(resultado.getDouble("faturamento"));
				musicas.setAgendarSessao(resultado.getString("agendarSessao"));
				musicas.setMixarMusica(resultado.getDouble("mixarMusica"));
				musicas.setValorTotal(resultado.getDouble("valorTotal"));
				
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return musicas;
		
	}
	
	public void excluiPorIdCliente(int idCliente) {
		Connection con = Conexao.obterConexao();
		
		String sql = "DELETE FROM Music WHERE idCliente=?";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, idCliente);
			preparador.execute();
			preparador.close();
			
			System.out.println("Aluno Excluido com Sucesso!!!");
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
			
	}
	
	public void altera (Music musicas) {
		
		Connection con = Conexao.obterConexao();
		
		String sql = "UPDATE Music set nomeEstudio=?, nomeCliente=?, numMusicasGravadas=?, taxaHoraEstudio=?, faturamento=?, agendarSessao=?, mixarMusica=?, valorTotal=? WHERE idCliente=?";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1,musicas.getNomeEstudio());
			preparador.setString(2,musicas.getNomeCliente());
			preparador.setDouble(3,musicas.getNumMusicasGravadas());
			preparador.setDouble(4,musicas.getTaxaHoraEstudio());
			preparador.setDouble(5,musicas.getFaturamento());
			preparador.setString(6, musicas.getAgendarSessao());
			preparador.setDouble(7, musicas.getMixarMusica());
			preparador.setDouble(8, musicas.getValorTotal());
			preparador.setInt(9,musicas.getIdCliente());
			preparador.execute();
			preparador.close();
			
			System.out.println("Aluno Alterado com Sucesso!!!");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}	
		
	}
	
	public Music autentica(String login, String senha) {
		
		Connection con = Conexao.obterConexao();
		
		Music usuariomusic = null;
		
		String sql = "SELECT * FROM Music WHERE login=? and senha=?";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, login);
			preparador.setString(2, senha);
			ResultSet resultado = preparador.executeQuery();
			
			if(resultado.next()) {
				usuariomusic = new Music();
				
				usuariomusic.setIdCliente(resultado.getInt("IdCliente"));
				usuariomusic.setNomeEstudio(resultado.getString("nomeEstudio"));
				usuariomusic.setNomeCliente(resultado.getString("nomeCliente"));
				usuariomusic.setNumMusicasGravadas(resultado.getDouble("numMusicasGravadas"));
				usuariomusic.setTaxaHoraEstudio(resultado.getDouble("taxaHoraEstudio"));
				usuariomusic.setFaturamento(resultado.getDouble("faturamento"));
				usuariomusic.setAgendarSessao(resultado.getString("agendarSessao"));
				usuariomusic.setMixarMusica(resultado.getDouble("mixarMusica"));
				usuariomusic.setValorTotal(resultado.getDouble("valorTotal"));
				usuariomusic.setLogin(resultado.getString("login"));
				usuariomusic.setSenha(resultado.getString("senha"));
			}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuariomusic;
		
	}
	
}
