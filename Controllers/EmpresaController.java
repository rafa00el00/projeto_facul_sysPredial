package Controllers;
import languages.*;
import Models.*;
import Funcoes.*;
import DAO.*;
import java.util.ArrayList;
import Views.*;

public abstract class EmpresaController{
   
   private static MyList<Empresa> empresas;
   
   public static void init(){
      empresas = (new EmpresaDao()).consultarTodos(new Empresa());
      //empresas = new MyList<Empresa>();
   }
   
   public static void consultar(){
            
      //dados para teste
                                       
      /*for (int i =0;i <=5;i++){
         Empresa ep = new Empresa();
         ep.setCnpj("CNPJ"+i);
         ep.setRazaoSocial("N"+i);
         ep.setHorarioFuncionamento(new Date());
         ep.setTemperaturaPadrao(i);
         ep.setHorarioArCondicionado(new Date());
         empresas.add(ep);
      }*/
   
      GuiEmpresa gui = new GuiEmpresa(empresas);
      gui.setVisible(true);
   }
   
   public static void consultar(String pesquisa,GuiConsultar gui){
      gui.atualizarTabela(empresas.find(e->e.getRazaoSocial().contains(pesquisa)));
   }
   
   public static boolean incluir(Empresa empresa){
      try{
         empresa.incluir();
      }
      catch(Exception e){
         e.printStackTrace();
         return false;
      }
      return true;
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
      }
      catch(Exception e){
         e.printStackTrace();
      }
      
   }   


}
