package Models;
import Interfaces.*;
import java.util.*;

public class Conjunto extends IEntidade{
   
   private String nrConjunto;
   private Empresa empresa;
   
   
   //Setters
   public void setNrConjunto(String nrConjunto)
   {
      this.nrConjunto = nrConjunto;
   }

//Getters
   public String getNrConjunto()
   {
      return this.nrConjunto;
   }


}