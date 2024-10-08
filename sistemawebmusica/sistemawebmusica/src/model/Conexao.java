package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	public static Connection obterConexao() {
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/databasemusic?useSSL=false", "root", "admin");
			System.out.println("O BANCO DE DADOS FOI CONECTADO COM SUCESSO!!!");
			
		}catch(SQLException | ClassNotFoundException e) {
			System.err.println("NÃO FOI POSSIVEL CONECTAR COM O BANCO DE DADOS!!!");
			e.printStackTrace();
		}
		
		return con;
	}

}
