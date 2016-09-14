package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.*;

public class DAOEmpresa{

    public void incluir(Empresa empresa, Connection conn)
   {
      String sqlInsert = "INSERT INTO Empresa(cnpj,razaoSocial ,horarioFuncionamento ,temperaturaPadrao,horarioArCondicionado) VALUES (?, ?,?, ?, ?)";
      PreparedStatement stm = null;
      try
      {
         stm = conn.prepareStatement(sqlInsert);
         stm.setString(1, empresa.getCnpj());
         stm.setString(2, empresa.getRazaoSocial());
         stm.setDate(3, empresa.getHorarioFuncionamento());
         stm.setInt(4, empresa.getTemperaturaPadrao());
         stm.setDate(5, empresa.getHorarioArCondicionado());
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
   
   public IEntidade consultar(IEntidade entidade, Connection conn)
   {
      String sqlSelect = "SELECT * FROM Empresa where codigo = ?";
      PreparedStatement stm = null;
      ResultSet rs = null;
      Empresa empresa = new Empresa();
      try
      {
         stm = conn.prepareStatement(sqlSelect);
         stm.setInt(1,id);
         rs = stm.executeQuery();
         while (rs.next())
         {
            
            empresa.setid(rs.getInt("id"));
            empresa.setCnpj(rs.getString("cnpj"));
            empresa.setRazaoSocial(rs.getString("razaoSocial"));
            empresa.setHorarioFuncionamento(rs.getDate("horarioFuncionamento"));
            empresa.setTemperaturaPadrao(rs.getInt("temperaturaPadrao"));
            empresa.setHorarioArCondicionado(rs.getDate("horarioArCondicionado"));
                  
            
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
      return (aluno);
   }

   
   
   

}