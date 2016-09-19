package Controllers;
import languages.*;
import Models.*;
import Funcoes.*;
import DAO.*;
import java.util.ArrayList;
import Views.*;

public abstract class UsuarioController{
   
   private static ArrayList<Usuario> usuarios;
   
   public static void init(){
      usuarios = (new UsuarioDao()).consultarTodos(new Usuario());
   }
   
   public static void consultar(){
      GuiUsuario usr = new GuiUsuario(usuarios);
      usr.setVisible(true);
   }
   
   public static void consultar(String pesquisa,GuiConsultar gui){
      gui.atualizarTabela(usuarios);
   }
   
   public static boolean incluir(Usuario usr){
      Login lg = new Login();
      
      try{
         lg.addLogin(usr);
         lg.salvarAlteracoes();
         usr.incluir();
         usuarios.add(usr);  
      }
      catch(Exception e){
         e.printStackTrace();
         return false;
      }
      return true;
   }

}
