package languages;
import java.util.Locale;
import java.util.ResourceBundle;

public abstract class Idiomas{
   private static ResourceBundle bn = null;
  
   public static void iniciar(){
     bn = ResourceBundle.getBundle("Idiomas/ex1");
   }
   
   
   public static String getString(String nome){
      return bn.getString(nome);
   }
   
   public static void changeIdioma(){
      bn = ResourceBundle.getBundle("Idiomas/ex1", new Locale("pt", "BR"));
   }
}