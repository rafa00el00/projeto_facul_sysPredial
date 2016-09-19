package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Models.*;
import Interfaces.*;
public class UsuarioDao extends AbstractDao{

   public UsuarioDao(){
      super();
   }

   //incluir
   public void incluir(Usuario usr)
   {
   
      String sqlInsert = "INSERT INTO Usuario("
         +"login"
         +",CPF"
         +",empresa_id"
         +",horaAcesso"
         +",horaSaida"
         +")"
         +" VALUES (?, ?, ?, ?, ?)";
      PreparedStatement stm = null;
      try
      {
         stm = conn.prepareStatement(sqlInsert);
         stm.setString(1, usr.getLogin());
         stm.setString(2, usr.getCPF());
         stm.setInt(3, usr.getEmpresa().getId());
         stm.setString(4, usr.getHoraAcesso());
         stm.setString(5, usr.getHoraSaida());
         stm.execute();
      }
      catch (Exception e)
      {
         e.printStackTrace();
         try
         {
            conn.rollback();
         }
         catch (SQLException e1)
         {
            System.out.print(e1.getStackTrace());
         }
         finally
         {
            if (stm != null)
            {
               try
               {
                  stm.close();
               }
               catch (SQLException e1)
               {
                  System.out.print(e1.getStackTrace());
               }
            }
         }
      }
   }
   
   //alterar
   public void alterar(Usuario usr)
   {
   
      String sqlInsert = "INSERT INTO Usuario("
         +"login = ?"
         +",CPF = ?"
         +",empresa_id = ?"
         +",horaAcesso = ?"
         +",horaSaida = ?"
         +")"
         +" where id = ?";
         
      PreparedStatement stm = null;
      try
      {
         stm = conn.prepareStatement(sqlInsert);
         stm.setString(1, usr.getLogin());
         stm.setString(2, usr.getCPF());
         stm.setInt(3, usr.getEmpresa().getId());
         stm.setString(4, usr.getHoraAcesso());
         stm.setString(5, usr.getHoraSaida());
         stm.setInt(6, usr.getId());
         stm.execute();
      }
      catch (Exception e)
      {
         e.printStackTrace();
         try
         {
            conn.rollback();
         }
         catch (SQLException e1)
         {
            System.out.print(e1.getStackTrace());
         }
         finally
         {
            if (stm != null)
            {
               try
               {
                  stm.close();
               }
               catch (SQLException e1)
               {
                  System.out.print(e1.getStackTrace());
               }
            }
         }
      }
   }
   
   //Consultar
   public Usuario consultar(IEntidade entidade)
   {
      String sqlSelect = "SELECT * FROM Usuario";
      Usuario usr;
      if (entidade instanceof Usuario){
         sqlSelect += " where id = ?";
      }
       usr= new Usuario();

      PreparedStatement stm = null;
      ResultSet rs = null;
      Empresa empresa = new Empresa();
      try
      {
         stm = conn.prepareStatement(sqlSelect);
         if (entidade instanceof Usuario){
            stm.setInt(1,entidade.getId());
         }
         rs = stm.executeQuery();
                 while (rs.next())
         {
            
            usr.setId(rs.getInt("id"));
            usr.setCPF(rs.getString("cpf"));
            usr.setLogin(rs.getString("login"));
            usr.setNome(rs.getString("nome"));
            usr.setEmpresa(new Empresa());
            usr.getEmpresa().setId(rs.getInt("empresa_id"));
            usr.setHoraAcesso(rs.getString("horaAcesso"));
            usr.setHoraSaida(rs.getString("horaSaida"));
                  
            
         }
      }
      catch (Exception e)
      {
         e.printStackTrace();
         try
         {
            conn.rollback();
         }
         catch (SQLException e1)
         {
            System.out.print(e1.getStackTrace());
         }
      }
      finally
      {
         if (stm != null)
         {
            try
            {
               stm.close();
            }
            catch (SQLException e1)
            {
               System.out.print(e1.getStackTrace());
            }
         }
      }
      return (usr);
   }
   
   //Consultar
   public ArrayList<Usuario> consultarTodos(IEntidade entidade)
   {
      String sqlSelect = "SELECT * FROM Usuario";
      ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
      Usuario usr;
      if (entidade instanceof Empresa){
         sqlSelect += " where empresa_id = ?";
      }
       

      PreparedStatement stm = null;
      ResultSet rs = null;
      Empresa empresa = new Empresa();
      try
      {
         stm = conn.prepareStatement(sqlSelect);
         if (entidade instanceof Usuario){
            //traz todos
         }else if (entidade instanceof Empresa){
            stm.setInt(1,((Empresa)entidade).getId());
         }
         rs = stm.executeQuery();
         while (rs.next())
         {
            usr= new Usuario();
            usr.setId(rs.getInt("id"));
            usr.setCPF(rs.getString("cpf"));
            usr.setLogin(rs.getString("login"));
            usr.setNome(rs.getString("nome"));
            usr.setEmpresa(new Empresa());
            usr.getEmpresa().setId(rs.getInt("empresa_id"));
            usr.setHoraAcesso(rs.getString("horaAcesso"));
            usr.setHoraSaida(rs.getString("horaSaida"));
             usuarios.add(usr);     
            
         }
      }
      catch (Exception e)
      {
         e.printStackTrace();
         try
         {
            conn.rollback();
         }
         catch (SQLException e1)
         {
            System.out.print(e1.getStackTrace());
         }
      }
      finally
      {
         if (stm != null)
         {
            try
            {
               stm.close();
            }
            catch (SQLException e1)
            {
               System.out.print(e1.getStackTrace());
            }
         }
      }
      return usuarios;
   }




}

