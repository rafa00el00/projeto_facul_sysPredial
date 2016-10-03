package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class AbstractDao{
   protected Connection conn;
   
   public AbstractDao(){
      try{
         conn = AcessoBD.getInstance();
      }
      catch(Exception e){
         e.printStackTrace();
      }
   }
  
}