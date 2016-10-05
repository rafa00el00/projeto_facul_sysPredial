package Models;
import Interfaces.*;
import DAO.*;
import java.util.*;

public class Conjunto extends IEntidade{
   
   private String nrConjunto;
   private String Andar;
   private double Alugel;
   private int tamanho;
   private boolean ocupado;
   private Empresa empresa;
   
   private ConjuntoDao dao;
   
   public Conjunto(){
      dao = new ConjuntoDao();
   }
   
   //Getters and Setters
   public String getNrConjunto() {
      return nrConjunto;
   }
   public void setNrConjunto(String nrConjunto) {
      this.nrConjunto = nrConjunto;
   }
   public String getAndar() {
      return Andar;
   }
   public void setAndar(String andar) {
      Andar = andar;
   }
   public double getAlugel() {
      return Alugel;
   }
   public void setAlugel(double alugel) {
      Alugel = alugel;
   }
   public int getTamanho() {
      return tamanho;
   }
   public void setTamanho(int tamanho) {
      this.tamanho = tamanho;
   }
   public boolean isOcupado() {
      return ocupado;
   }
   public void setOcupado(boolean ocupado) {
      this.ocupado = ocupado;
   }
   public Empresa getEmpresa() {
      return empresa;
   }
   public void setEmpresa(Empresa empresa) {
      this.empresa = empresa;
   }
	   
	   
   public void inserir(){dao.incluir(this); }
   public void alterar(){dao.alterar(this); }
   public void consultar(){dao.consultar(this); }
   public void deletar(){dao.deletar(this); }  	

}