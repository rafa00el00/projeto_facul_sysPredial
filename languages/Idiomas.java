package languages;
import java.util.Locale;
import java.util.ResourceBundle;

public abstract class Idiomas{
   private static ResourceBundle bn = null;
   
   public enum IDIOMASDISPONIVEIS{
      EN,PT,SP
   }
  
   public static void iniciar(){
      bn = ResourceBundle.getBundle("Idiomas/ex1");
   }
   
   
   public static String getString(String nome){
      return bn.getString(nome);
   }
   
   public static void changeIdioma(IDIOMASDISPONIVEIS idm){
      if (idm == IDIOMASDISPONIVEIS.PT){
         bn = ResourceBundle.getBundle("Idiomas/ex1", new Locale("pt", "BR"));
      }
      else if (idm == IDIOMASDISPONIVEIS.EN){
         bn = ResourceBundle.getBundle("Idiomas/ex1", new Locale("en", "US"));
      }
      else if (idm == IDIOMASDISPONIVEIS.SP){
         bn = ResourceBundle.getBundle("Idiomas/ex1", new Locale("sp", "SP"));
      }
   }
}