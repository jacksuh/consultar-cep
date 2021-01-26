package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {
	private static String banco ="jdbc:postgresql://localhost:5432/endereco?autoReconnect=true";
	private static String user = "postgres";
	private static String password = "admin";
	private static Connection connection = null;

	/*
	 * Chamada Estática do Método conectar()
	 */
	static {
		conectar();
	}
	
	/*
	 * Construtor da Classe SingleConnection()
	 * Chama o Método conectar()
	 */
	public SingleConnection() {
		conectar();
	}
	
	/*
	 * Método conectar()
	 * Provê os Meios de Conexão ao BD
	 */
	private static void conectar() {
		try {
			if(connection == null) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(banco, user, password);
				connection.setAutoCommit(false);
			}
		} catch(Exception e) {
			e.printStackTrace();
			e.printStackTrace();
			throw new RuntimeException("Erro ao Conectar com o Banco de Dados");
		}
	}
	
	/*
	 * Método getConnection()
	 * Responsável Por Fazer Uso da Conexão na Aplicação
	 */
	public static Connection getConnection() {
		return connection;
	}
}
