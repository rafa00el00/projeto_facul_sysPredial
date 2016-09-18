import Funcoes.*;
import Views.*;
import languages.*;

import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import java.security.cert.*;
import java.io.*;
public class Inicio{
   
   public static void main(String args[]){
     Idiomas.iniciar();
      GuiLogin lg = new GuiLogin(null);
      lg.setVisible(true);         
   }

}