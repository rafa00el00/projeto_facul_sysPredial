package Controllers;
import languages.*;
import Models.*;
import Funcoes.*;
import DAO.*;
import java.util.ArrayList;

import javax.swing.JFrame;

import Views.*;

public abstract class EmpresaController{
   
   private static MyList<Empresa> empresas;
   
   public static void init(){
      empresas = (new EmpresaDao()).consultarTodos(new Empresa());
      //empresas = new MyList<Empresa>();
   }
   
   public static void consultar(){
   
      GuiEmpresa gui = new GuiEmpresa(empresas);
      gui.setVisible(true);
   }
   
   public static void consultar(String pesquisa,GuiConsultar gui){
      gui.atualizarTabela(empresas.find(e->e.getRazaoSocial().toUpperCase().contains(pesquisa.toUpperCase())));
   }
   
   public static void incluir(JFrame fr){
      GuiCadEmpresa cad = new GuiCadEmpresa(fr, false);
      cad.setLstConjunto((new ConjuntoDao()).consultarTodos(new Conjunto()).find(c->c.isOcupado()==false));
      cad.setVisible(true);
   }

   public static boolean incluir(Empresa empresa){
      try{
         empresa.incluir();
         empresas.add(empresa);
      }
      catch(Exception e){
         e.printStackTrace();
         return false;
      }
      return true;
   }
   
    
   public static void alterar(JFrame fr,Empresa empresa){
      GuiCadEmpresa cad = new GuiCadEmpresa(fr, true, empresa);
      cad.setLstConjunto((new ConjuntoDao()).consultarTodos(new Conjunto()).find(c->c.isOcupado()==false));
      cad.setVisible(true);
   }
   
   public static void alterar(Empresa empresa){
      try{
         empresa.alterar();
      }
      catch(Exception e){
         e.printStackTrace();
      }
   }
   
   public static void deletar(Empresa empresa){
      try{
         empresa.deletar();
         empresas.remove(empresa);
      }
      catch(Exception e){
         e.printStackTrace();
      }
      
   }   


}
