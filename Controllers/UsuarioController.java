package Controllers;
import languages.*;
import Models.*;
import Funcoes.*;
import DAO.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import Views.*;

public abstract class UsuarioController{
   
   private static MyList<Usuario> usuarios;
   
   public static void init(){
      usuarios = (new UsuarioDao()).consultarTodos(new Usuario());
     //usuarios = new MyList<Usuario>();
   }
   
   public static void consultar(){
            
      /*for (int i =0;i <=5;i++){
         Usuario fn = new Usuario();
         fn.setCPF("CPF"+i);
         fn.setNome("N"+i);
         fn.setEmpresa(new Empresa("Cnpj"+i,"Empresa "+i));
         fn.setHoraAcesso("H"+i);
         fn.setHoraSaida("S"+i);      
         usuarios.add(fn);
      }*/
   
      GuiUsuario usr = new GuiUsuario(usuarios);
      usr.setVisible(true);
   }
   
   public static void consultar(String pesquisa,GuiConsultar gui){
      gui.atualizarTabela(usuarios.find(e->e.getNome().contains(pesquisa)));
   }
   
   public static boolean incluir(JFrame fm){
      GuiCadUsuarios cad = new GuiCadUsuarios(fm,false);
      cad.setLstEmpresas((new EmpresaDao()).consultarTodos(new Usuario()));
      cad.setVisible(true);
      return true;
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
   
   public static void alterar(Usuario usr){
      usr.alterar();
   }
   
   public static void deletar(Usuario usr){
      usr.deletar();
   }   


}
