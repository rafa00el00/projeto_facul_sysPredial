package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
* Classe responsável pela conexão com banco de dados MySQL
*/
public abstract class AcessoBD
{
// -----------------------------------------------------------
// Carrega driver JDBC
//
   static
   {
      try
      {
         Class.forName("com.mysql.jdbc.Driver");
      }
      catch (ClassNotFoundException e)
      {
         throw new RuntimeException(e);
      }
   }
// -----------------------------------------------------------
// Obtém conexão com o banco de dados
   public static Connection getInstance() throws SQLException
   {
      return DriverManager.getConnection
         (
         "jdbc:mysql://LocalHost/sysPredial?user=alunos&password=alunos"
         );
   }
}