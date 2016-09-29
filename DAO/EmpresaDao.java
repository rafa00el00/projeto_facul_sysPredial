package DAO;
import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Models.*;
import Interfaces.*;
import Funcoes.*;

public class EmpresaDao extends AbstractDao{

   public EmpresaDao(){
      super();
   }

   //incluir
   public void incluir(Empresa empresa)
   {
   
      String sqlInsert = "INSERT INTO Empresa("
         +"CNPJ"
         +",RAZAOSOCIAL"
         +",TemperaturaAr"
         +",horaAbertura"
         +",horaFechamento"
         +",horaIniAr"
         +",horaFimAr"
         +")"
         +" VALUES (?, ?, ?, ?, ?,?,?)";
      PreparedStatement stm = null;
      try
      {
         stm = conn.prepareStatement(sqlInsert);
         stm.setString(1, empresa.getCnpj());
         stm.setString(2, empresa.getRazaoSocial());
         stm.setInt(3, empresa.getTemperaturaPadrao());
         stm.setDate(4, (Date) empresa.getHorarioAbertura());
         stm.setDate(4, (Date) empresa.getHorarioFechamento());
         stm.setDate(4, (Date) empresa.getHoraIniAr());
         stm.setDate(4, (Date) empresa.getHoraFimAr());
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
   public void alterar(Empresa empresa)
   {
   
      String sqlInsert = "Update Empresa set "
    		  +"CNPJ = ?"
    	      +",RAZAOSOCIAL = ?"
    	      +",TemperaturaAr = ?"
    	      +",horaAbertura = ?"
    	      +",horaFechamento = ?"
    	      +",horaIniAr = ?"
    	      +",horaFimAr = ?"
         +""
         +" where id = ?";
         
      PreparedStatement stm = null;
      try
      {
         stm = conn.prepareStatement(sqlInsert);
         stm.setString(1, empresa.getCnpj());
         stm.setString(2, empresa.getRazaoSocial());
         stm.setInt(3, empresa.getTemperaturaPadrao());
         stm.setDate(4, (Date) empresa.getHorarioAbertura());
         stm.setDate(5, (Date) empresa.getHorarioFechamento());
         stm.setDate(6, (Date) empresa.getHoraIniAr());
         stm.setDate(7, (Date) empresa.getHoraFimAr());
         stm.setInt(3, empresa.getTemperaturaPadrao());
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
   public Empresa consultar(IEntidade entidade)
   {
      String sqlSelect = "SELECT * FROM Empresa";
       if (entidade instanceof Empresa){
         sqlSelect += " where id = ?";
      }
       

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
            
            empresa.setId(rs.getInt("id"));
            empresa.setCnpj(rs.getString("cpf"));
            empresa.setRazaoSocial (rs.getString("login"));
            empresa.setTemperaturaPadrao(rs.getInt("nome"));
            empresa.setHorarioAbertura(rs.getDate("empresa_id"));
            empresa.setHorarioFechamento(rs.getDate("empresa_id"));
            empresa.setHoraIniAr(rs.getDate("empresa_id"));
            empresa.setHoraFimAr(rs.getDate("empresa_id"));
                  
            
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
      return (empresa);
   }
   
   //Consultar
   public MyList<Empresa> consultarTodos(IEntidade entidade)
   {
      String sqlSelect = "SELECT * FROM Empresa";
      MyList<Empresa> empresas = new MyList<Empresa>();
      
     /* if (entidade instanceof Empresa){
         sqlSelect += " where id = ?";
      }*/
       

      PreparedStatement stm = null;
      ResultSet rs = null;
      Empresa empresa = new Empresa();
      try
      {
         stm = conn.prepareStatement(sqlSelect);
         /*if (entidade instanceof Usuario){
            //traz todos
         }else if (entidade instanceof Empresa){
            stm.setInt(1,((Empresa)entidade).getId());
         }*/
         rs = stm.executeQuery();
         while (rs.next())
         {
            empresa = new Empresa();
          empresa.setId(rs.getInt("id"));
            empresa.setCnpj(rs.getString("cpf"));
            empresa.setRazaoSocial (rs.getString("login"));
            empresa.setTemperaturaPadrao(rs.getInt("nome"));
            empresa.setHorarioAbertura(rs.getDate("empresa_id"));
            empresa.setHorarioFechamento(rs.getDate("empresa_id"));
            empresa.setHoraIniAr(rs.getDate("empresa_id"));
            empresa.setHoraFimAr(rs.getDate("empresa_id"));
             empresas.add(empresa);     
            
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
      return empresas;
   }




}

