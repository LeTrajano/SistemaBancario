package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {

    // Constantes para as informações de conexão
    private static final String USUARIO = "root";
    private static final String SENHA = "1234";
    private static final String URL = "jdbc:mysql://localhost:3306/sistema_bancario";

    public static Connection conn; // Variável para armazenar a conexão

    /**
     * Método para obter uma conexão com o banco de dados.
     * 
     * @return Uma instância da classe Connection que representa a conexão com o
     *         banco de dados.
     */
    public static Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) { // Verifica se a conexão ainda não foi criada ou está fechada
                conn = DriverManager.getConnection(URL, USUARIO, SENHA); // Cria a conexão com o banco de dados
            }
            return conn; // Retorna a conexão existente ou recém-criada
        } catch (SQLException e) {
            e.printStackTrace(); // Em caso de erro, imprime o erro no console
            return null; // Retorna null em caso de falha na conexão
        }
    }

    /**
     * Método para fechar a conexão com o banco de dados.
     * 
     * @param conn A instância da classe Connection que representa a conexão a ser
     *             fechada.
     */
    public static void fechar(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) { // Verifica se a conexão não é nula e não está fechada
                conn.close(); // Fecha a conexão
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Em caso de erro, imprime o erro no console
        }
    }
}
