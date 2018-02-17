package br.com.gestionnaire.domain;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class BaseDAO {
	
		public BaseDAO() {
			try {
				// Necessário para utilizar o driver JDBC do MySQL
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// Erro de driver JDBC (adicione o driver .jar do MySQL em WEB-INF/lib)
				e.printStackTrace();
			}
		}

		protected Connection getConnection() throws SQLException {
			// URL de conexão com o banco de dados
//			String url = "jdbc:mysql://localhost/livro";
			String url = "jdbc:mysql://localhost/tabarnupp";

			// Conecta utilizando a URL, usuário e senha.
//			Connection conn = (Connection) DriverManager.getConnection(url, "livro", "livro123");
			Connection conn = (Connection) DriverManager.getConnection(url, "root", "root");

			return conn;
		}

		public static void main(String[] args) throws SQLException {
			BaseDAO db = new BaseDAO();
			// Testa a conexão
			Connection conn = db.getConnection();
			System.out.println("Conectado com exito! " +conn);
		}
}
