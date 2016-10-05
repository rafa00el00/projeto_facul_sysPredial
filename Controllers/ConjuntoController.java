package Controllers;
import languages.*;
import Models.*;
import Funcoes.*;
import DAO.*;
import java.util.ArrayList;
import Views.*;

public abstract class ConjuntoController{
   
   private static MyList<Conjunto> conjuntos;
   
   public static void init(){
      conjuntos = (new ConjuntoDao()).consultarTodos(new Conjunto());
      //empresas = new MyList<Empresa>();
   }
   
   public static void consultar(){

      GuiConjunto gui = new GuiConjunto(conjuntos);
      gui.setVisible(true);
   }
   
   public static void consultar(String pesquisa,GuiConsultar gui){
      //gui.atualizarTabela(conjuntos.find(e->e.getRazaoSocial().contains(pesquisa)));
   }
   
   public static boolean incluir(Conjunto conjunto){
      try{
         conjunto.incluir();
         conjuntos.add(conjunto);
      }
      catch(Exception e){
         e.printStackTrace();
         return false;
      }
      return true;
   }
   
   public static void alterar(JFrame fm,Conjunto conjunto){
       GuiCadConjunto cad = new GuiCadConjunto(fm,true,conjunto);
         cad.setVisible(true);

   }
   
   public static void alterar(Conjunto conjunto){
      try{
         conjunto.alterar();
      }
      catch(Exception e){
         e.printStackTrace();
      }
   }
   
   public static void deletar(Conjunto conjunto){
      try{
         conjunto.deletar();
         conjuntos.remove(conjunto);
      }
      catch(Exception e){
         e.printStackTrace();
      }
      
   }   


}
