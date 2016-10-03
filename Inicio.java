import Funcoes.*;
import Views.*;
import languages.*;
import Models.*;
import Controllers.*;

import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import java.security.cert.*;
import java.io.*;
public class Inicio{
   
   public static void main(String args[]){
      Idiomas.iniciar();
      //Inicia os Controllers
      UsuarioController.init();
      EmpresaController.init();
      
      GuiLogin lg = new GuiLogin(null);
      lg.setVisible(true);  
             
   }

}